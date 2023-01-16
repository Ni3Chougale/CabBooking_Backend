package com.springrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Registration {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long registrationId;
	
	@NotEmpty(message="Name should not be empty")
	private String userName;
	
	@Column(unique = true)
	@Email
	private String emailId;
	
	@NotEmpty(message = "Password should not be empty")
	@Size(min = 4, max = 10, message = "Password should be minimum of 4 & maximum of 10 characters")
	private String password;
	
	@Size(min = 10, max = 10, message = "contact number must be exact 10 characters")
	private String contactNo;
	private boolean isAdmin;
	
	public Registration(long registrationId, @NotEmpty(message = "Name should not be empty") String userName,
			@Email String emailId,
			@NotEmpty(message = "Password should not be empty") @Size(min = 4, max = 10, message = "Password should be minimum of 4 & maximum of 10 characters") String password,
			@Size(min = 10, max = 10, message = "contact number must be exact 10 characters") String contactNo,
			boolean isAdmin) {
		super();
		this.registrationId = registrationId;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.contactNo = contactNo;
		this.isAdmin = isAdmin;
	}
	public Registration() {
		super();
	}
	public long getRegistrationId() {
		return registrationId;
	}
	public void setRegistrationId(long registrationId) {
		this.registrationId = registrationId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public String toString() {
		return "Registration [registrationId=" + registrationId + ", userName=" + userName + ", emailId=" + emailId
				+ ", password=" + password + ", contactNo=" + contactNo + ", isAdmin=" + isAdmin + "]";
	}
}
