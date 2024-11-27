package com.sap.Conversession.services.markups;

import com.sap.Conversession.modal.UserModal;

public interface UserServicesMarkup {
	boolean register(UserModal u) ;
	boolean validateUser(String email, String username, String password);
}
