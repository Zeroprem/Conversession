package com.sap.Conversession.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@PostMapping("/login")
	String login(){
		
		return"hello";
	}
	
	

}
