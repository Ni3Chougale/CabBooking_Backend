package com.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.model.DriverInfo;
import com.springrest.repository.DriverInfoRepo;

@Service
public class DriverInfoServiceImpl implements DriverInfoService{

	@Autowired
	DriverInfoRepo driverInfoRepo;
	
	
	@Override
	public DriverInfo addDriverInfo(DriverInfo driver) {
		return driverInfoRepo.save(driver);
	}

	@Override
	public DriverInfo getDriverInfoById(int id) {
		return driverInfoRepo.findById(id).get();
	}

	@Override
	public List<DriverInfo> getAllDriverInfo() {
		List<DriverInfo> list = driverInfoRepo.findAll();
		return list;
	}

	@Override
	public DriverInfo updateDriverInfo(DriverInfo driver, int id) {
		
		Optional<DriverInfo> op = driverInfoRepo.findById(id);
		if(op.isPresent()) {
			DriverInfo driverInfo = op.get();
			driverInfo.setDriverName(driver.getDriverName());
			driverInfo.setAddress(driver.getAddress());
			driverInfo.setAadharNo(driver.getAadharNo());
			driverInfo.setDob(driver.getDob());
			driverInfo.setMobileNo(driver.getMobileNo());
			driverInfo.setLicenseNo(driver.getLicenseNo());
			
			driverInfoRepo.save(driverInfo);
		}
		else {
			System.out.println("Driver info is not available");
		}
		System.out.println("Driver info added successfully");
		return driver;
	}

	@Override
	public void deleteDriverById(int id) {
		DriverInfo book = new DriverInfo();
		
		try {
			book = getDriverInfoById(id);
			
			if(book!=null) {
				driverInfoRepo.deleteById(id);
			}
		}
		catch(Exception e) {
			System.out.println("Exception while removing driver info");
		}
		System.out.println("Driver info removed successfully");
	}
}
