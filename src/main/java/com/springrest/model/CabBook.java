package com.springrest.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.engine.jdbc.internal.DDLFormatterImpl;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
public class CabBook {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	
	@NotEmpty(message = "source can not be empty")
    private String source;
	
	@NotEmpty(message = "destination can not be empty")
    private String destination;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "driverId")
	private DriverInfo driverId;
	private int userId;
	
	public CabBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public CabBook(int bookingId, @NotEmpty(message = "source can not be empty") String source,
			@NotEmpty(message = "destination can not be empty") String destination, Date startDate, Date endDate,
			DriverInfo driverId, int userId) {
		super();
		this.bookingId = bookingId;
		this.source = source;
		this.destination = destination;
		this.startDate = startDate;
		this.endDate = endDate;
		this.driverId = driverId;
		this.userId = userId;
	}


	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public DriverInfo getDriverId() {
		return driverId;
	}
	public void setDriverId(DriverInfo driverId) {
		this.driverId = driverId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CabBook [bookingId=" + bookingId + ", source=" + source + ", destination=" + destination
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", userId=" + userId + "]";
	}
	
}
