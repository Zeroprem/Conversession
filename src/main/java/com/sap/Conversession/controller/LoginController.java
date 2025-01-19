package com.sap.Conversession.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sap.Conversession.modal.UserModal;
import com.sap.Conversession.services.implementation.UserService;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserModal user) {
        boolean isValidUser = userService.validateUser(user.getEmail(), user.getUsername(), user.getPassword());
        if (isValidUser) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid email/username or password");
        }
    }
}
