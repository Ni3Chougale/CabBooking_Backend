package com.springrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.model.CabBook;

@Repository
public interface CabBookRepo extends JpaRepository<CabBook, Integer>{
	
	List<CabBook> findBookingByUserId(int id); 

}
