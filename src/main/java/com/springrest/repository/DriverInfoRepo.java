package com.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.model.DriverInfo;

@Repository
public interface DriverInfoRepo extends JpaRepository<DriverInfo, Integer>{
	
}
