package com.springrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springrest.model.CabBook;

@Service
public interface CabBookService {
	
	public CabBook addBooking(CabBook booking, int id);
	public CabBook getBookingById(int id);
	public List<CabBook> getAllBooking();
	public CabBook updateBooking (CabBook booking, int id);
	public void deleteBookingById(int id);
	public List<CabBook> findByUserId(int id);
}
