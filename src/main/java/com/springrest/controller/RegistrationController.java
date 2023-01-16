package com.springrest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.model.Registration;
import com.springrest.service.RegistrationService;
import com.springrest.service.RegistrationServiceImpl;

@RestController
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	public RegistrationServiceImpl registrationService;
	
	@PostMapping("/loginCustomer")
	public Registration loginUser(@RequestBody Registration r) throws Exception {
		String logemailId = r.getEmailId();
		String logpassword= r.getPassword();
		
		Registration regObj = null;
		System.out.println(logemailId+"  "+logpassword);
		
		if(logemailId != null && logpassword !=null) {
			regObj = registrationService.findByEmailIdAndPassword(logemailId, logpassword);
		}
		if(regObj.getEmailId().equals(logemailId) && regObj.getPassword().equals(logpassword)) {
			return regObj;
		}
		else {
			return regObj;
		}
	}
	
	@GetMapping("/findByEmail/{emailId}")
	public Registration findByEmailId(@PathVariable String emailId) {
		System.out.println("Inside find by mail");
		return registrationService.findByEmailId(emailId);
	}
	
	@GetMapping("/findById/{id}")
	public Registration findById(@PathVariable long id) {
		return registrationService.findById(id);
	}
	
	@PostMapping("/addRegistration")
	public Registration addNewRegistration(@Valid @RequestBody Registration register) {
		return registrationService.addNewRegistration(register);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public void deleteRegistration(@PathVariable long id) {
		registrationService.deleteRegistration(id);
	}
	@GetMapping("/getAllRegistration")
	public List<Registration> getAll(){
		List<Registration> r = new ArrayList<>();
		r = registrationService.getAllRegistrations();
		r = r.stream().filter(i -> i.isAdmin()==false).collect(Collectors.toList());
		System.out.println("all registration --" +r);
		return r;
	}
}

/*"userName":"priya",
"emailId":"priya@gmail.com",
"password":"priya123",
"contactNo":"7788996656",
"isAdmin":1
*/
