package com.sap.Conversession.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sap.Conversession.modal.UserModal;

public interface UserRepository extends JpaRepository<UserModal, Integer> {
	  boolean existsByEmail(String email);
	

}
