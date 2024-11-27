package com.sap.Conversession.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sap.Conversession.modal.UserModal;

public interface UserRepository extends JpaRepository<UserModal, Integer> {
	boolean existsByEmail(String email);
	
	boolean existsByUsername(String username);
	
	@Query("SELECT u.password FROM UserModal u WHERE u.email = :email")
    String findPasswordByEmail(@Param("email") String email);

    @Query("SELECT u.password FROM UserModal u WHERE u.username = :username")
    String findPasswordByUsername(@Param("username") String username);

}
