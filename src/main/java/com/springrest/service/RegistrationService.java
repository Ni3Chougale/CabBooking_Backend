package com.springrest.service;

import java.util.List;

import com.springrest.model.Registration;

public interface RegistrationService {
	
	public Registration findByEmailId(String emailId);
	public Registration findById(long id);
	public Registration findByEmailIdAndPassword(String emailId, String password);
	public Registration addNewRegistration(Registration register);
	public void deleteRegistration(long id);
	public List<Registration> getAllRegistrations();
}
