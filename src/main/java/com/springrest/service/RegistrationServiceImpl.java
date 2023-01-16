package com.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springrest.model.Registration;
import com.springrest.repository.RegistrationRepo;

@Component
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	RegistrationRepo registorRepo;

	@Override
	public Registration findByEmailId(String emailId) {
		return registorRepo.findByEmailId(emailId);
	}

	@Override
	public Registration findById(long id) {
		Registration r = registorRepo.findById(id).get();
		return r;
	}

	@Override
	public Registration findByEmailIdAndPassword(String emailId, String password) {
		Registration r = registorRepo.findByEmailIdAndPassword(emailId, password);
		return r;
	}

	@Override
	public Registration addNewRegistration(Registration register) {
		Registration r = registorRepo.save(register);
		return r;
	}

	@Override
	public void deleteRegistration(long id) {
		registorRepo.deleteById(id);
	}

	@Override
	public List<Registration> getAllRegistrations() {
		List<Registration> list = registorRepo.findAll();
		return list;
	}
}
