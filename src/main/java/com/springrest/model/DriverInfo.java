package com.springrest.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class DriverInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int driverId;
	
	@NotEmpty(message = "Driver name should not be empty.")
	public String driverName;
	
	@Size(min=10, max=10, message = "contact no. should be exctly of 10 characters")
	public String mobileNo;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date dob;
	
	@Size(min=12, max=12, message = "Aadhar no. should be of 12 characters")
	public String aadharNo;
	
	@NotEmpty(message = "Address should not be empty")
	public String address;
	
	@NotEmpty(message = "License number should not be empty")
	public String licenseNo;

	public DriverInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DriverInfo(int driverId, @NotEmpty(message = "Driver name should not be empty.") String driverName,
			@Size(min = 10, max = 10, message = "contact no. should be exctly of 10 characters") String mobileNo,
			Date dob, @Size(min = 12, max = 12, message = "Aadhar no. should be of 12 characters") String aadharNo,
			@NotEmpty(message = "Address should not be empty") String address,
			@NotEmpty(message = "License number should not be empty") String licenseNo) {
		super();
		this.driverId = driverId;
		this.driverName = driverName;
		this.mobileNo = mobileNo;
		this.dob = dob;
		this.aadharNo = aadharNo;
		this.address = address;
		this.licenseNo = licenseNo;
	}
	public int getDriverId() {
		return driverId;
	}
	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}
	public String getDriverName() {
		return driverName;
	}
	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	@Override
	public String toString() {
		return "DriverInfo [driverId=" + driverId + ", driverName=" + driverName + ", mobileNo=" + mobileNo + ", dob="
				+ dob + ", aadharNo=" + aadharNo + ", address=" + address + ", licenseNo=" + licenseNo + "]";
	}
}
