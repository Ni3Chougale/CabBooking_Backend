package com.springrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.model.DriverInfo;

@Service
public interface DriverInfoService {
	
	public DriverInfo addDriverInfo(DriverInfo driver);
	public DriverInfo getDriverInfoById(int id);
	public List<DriverInfo> getAllDriverInfo();
	public DriverInfo updateDriverInfo(DriverInfo driver, int id);
	public void deleteDriverById(int id);
	
}
