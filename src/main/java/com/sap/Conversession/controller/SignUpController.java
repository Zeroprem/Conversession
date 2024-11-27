package com.sap.Conversession.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sap.Conversession.modal.UserModal;
import com.sap.Conversession.services.implementation.UserService;
@RestController

public class SignUpController {
	@Autowired
	UserService uService;
	@PostMapping("/register")
	String register(@RequestBody UserModal u) {
		boolean flag =uService.register(u);
		
		return flag? "success":"already Exist";
	}
}
