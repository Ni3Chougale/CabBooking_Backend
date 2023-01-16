package com.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.model.CabBook;
import com.springrest.model.DriverInfo;
import com.springrest.repository.CabBookRepo;

@Service
public class CabBookServiceImpl implements CabBookService{
	
	@Autowired
	public CabBookRepo cabBookRepo;
	
	@Autowired
	public DriverInfoService driverInfoService;
	
	@Override
	public CabBook addBooking(CabBook booking, int id) {
		try
		{
			DriverInfo d=driverInfoService.getDriverInfoById(id);
			booking.setDriverId(d);
			System.out.println(d);
			cabBookRepo.save(booking);
			
		}
		catch (Exception e) {
			System.out.println("Exception while adding Booking"+e);
		}
		return booking;
	}
	@Override
	public CabBook getBookingById(int id) {
		Optional<CabBook> op=cabBookRepo.findById(id);
		if(op.isPresent())
		{
			CabBook book=op.get();
			 return book;
		}
		else 
		{
			System.out.println("Booking not availabe");
			return null;
		}
	}
	@Override
	public List<CabBook> getAllBooking() {
		List<CabBook> list=null;
		try {
			list=cabBookRepo.findAll();
		}
		catch (Exception e) {
			System.out.println("Exception while getting Booking");
		}
			return  list;
	}
	@Override
	public CabBook updateBooking(CabBook book, int id) {
		Optional<CabBook> op=cabBookRepo.findById(id);
		if(op.isPresent())
		{
			CabBook cabBook=op.get();
			cabBook.setSource(book.getSource());
			cabBook.setDestination(book.getDestination());
			
			cabBookRepo.save(cabBook);
		}
		else
		{
			System.out.println("Booking not available");
		}
		System.out.println("Booking Updating Successfully ");
		return book;
	}
	@Override
	public void deleteBookingById(int id) {
		
		CabBook book=new CabBook();
		
		try{
			
			book=getBookingById(id);
			if(book!=null)
			{
				cabBookRepo.deleteById(id);	
			}
		}
		catch (Exception e) {
			System.out.println("Exception while removing BookingById");
		}
		System.out.println("Booking deleted Successfully ");
	}
	@Override
	public List<CabBook> findByUserId(int id) {
		List<CabBook> list=cabBookRepo.findBookingByUserId(id);
		
		return list;
	}
	
	
}
