package com.sap.Conversession.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserModal {
	@Id
	private String email;
	private String username;
	private String password;
	
	public UserModal() {
	
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
