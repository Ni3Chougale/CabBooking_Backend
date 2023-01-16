package com.springrest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.model.DriverInfo;
import com.springrest.service.DriverInfoServiceImpl;

@RestController
@RequestMapping("/driver")
public class DriverInfoController {
	
	@Autowired
	public DriverInfoServiceImpl driverService;
	
	@GetMapping("/findDriverById/{id}")
	public DriverInfo findById(@PathVariable int id) {
		return driverService.getDriverInfoById(id);
	}
	
	@PostMapping("/addDriverInfo")
	public DriverInfo addDriverInfo(@Valid @RequestBody DriverInfo driver) {
		return driverService.addDriverInfo(driver);
	}
	
	@GetMapping("/getAllDriverInfo")
	public List<DriverInfo> getAllDriverInfo(){
		List<DriverInfo> list = driverService.getAllDriverInfo();
		return list;
	}
	
	@DeleteMapping("/deleteDriverInfoById/{id}")
	public void deleteDriverInfoById(@PathVariable int id) {
		driverService.deleteDriverById(id);
	}
	
	@PutMapping("/updateDriverInfoById/{id}")
	public DriverInfo updateDriverInfoById(@RequestBody DriverInfo driver,@PathVariable int id) {
		return driverService.updateDriverInfo(driver, id);
	}
}

/*
{
"driverName":"rohan",
"mobileNo":"9988767876",
"dob":"1970-12-11",
"aadharNo":333456567876,
"address":"Pune",
"licenseNo":"774456788"
}
*/

