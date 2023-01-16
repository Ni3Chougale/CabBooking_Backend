package com.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.model.Registration;

public interface RegistrationRepo extends JpaRepository<Registration, Long>{

	public Registration findByEmailId(String emailId);
	
	public Registration findByEmailIdAndPassword(String logemailId, String logpassword);
	
}
