package com.sap.Conversession.services.implementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sap.Conversession.modal.UserModal;
import com.sap.Conversession.repository.UserRepository;
import com.sap.Conversession.services.UserServicesMarkup;
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

}
