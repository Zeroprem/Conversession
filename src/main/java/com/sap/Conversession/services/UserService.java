package com.sap.Conversession.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.Conversession.modal.UserModal;
import com.sap.Conversession.repository.UserRepository;
import com.sap.Conversession.services.markups.UserServicesMarkup;
@Service
public class UserService implements UserServicesMarkup{

	@Autowired
	UserRepository ur;
	@Override
	public boolean register(UserModal u) {
		// Check if the email already exists
		 if (ur.existsByEmail(u.getEmail())) {
	            return false;  // Email exists, return false
	        }
		 // Save the new user and return true
	        ur.save(u);
	        return true;
	}
	public boolean validateUser(String email, String username, String password) {
        if (email != null && ur.existsByEmail(email)) {
            String storedPassword = ur.findPasswordByEmail(email);
            return storedPassword.equals(password); // Validate by email
        } else if (username != null && ur.existsByUsername(username)) {
            String storedPassword = ur.findPasswordByUsername(username);
            return storedPassword.equals(password); // Validate by username
        }
        return false; // User not found
    }

}
