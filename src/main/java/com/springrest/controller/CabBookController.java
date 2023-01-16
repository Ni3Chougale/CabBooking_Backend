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

import com.springrest.model.CabBook;
import com.springrest.service.CabBookServiceImpl;

@RestController
@RequestMapping("/booking")
public class CabBookController {
	
	@Autowired
	public CabBookServiceImpl bookServiceImpl;
	
	@GetMapping("/findBookingById/{id}")
	public CabBook findBookingById(@PathVariable int id) {
		CabBook r = bookServiceImpl.getBookingById(id);
		return r;
	}
	
	@PostMapping("/addBooking/{id}")
	public CabBook addBooking(@Valid @RequestBody CabBook booking,@PathVariable int id) {
		CabBook r = bookServiceImpl.addBooking(booking, id);
		return r;
	}
	@GetMapping("/getAllBooking")
	public List<CabBook> getAllBooking(){
		return bookServiceImpl.getAllBooking();
	}
	
	@PutMapping("/updateBookingById/{id}")
	public CabBook updateBookingById(CabBook booking, @PathVariable int id) {
		return bookServiceImpl.updateBooking(booking, id);
	}
	
	@DeleteMapping("/deleteBookingById/{id}")
	public void deleteBookingById(@PathVariable int id) {
		bookServiceImpl.deleteBookingById(id);
	}
	
	@GetMapping("/findBookingByUserId/{id}")
	public List<CabBook> findBookingByUserId(@PathVariable int id){
		List<CabBook> r = bookServiceImpl.findByUserId(id);
		return r;
	}
}

/*{
"source":"pune",
"destination":"nagpur",
"startDate":"2022-12-11",
"endDate":"2022-12-12"
}*/


