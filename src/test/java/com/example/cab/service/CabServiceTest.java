package com.example.cab.service;

import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.cab.model.CabDriver;
import com.example.cab.model.Coordinate;
import com.example.cab.repository.CabDriverRepository;

import net.bytebuddy.implementation.bytecode.ByteCodeAppender.Size;

@SpringBootTest
public class CabServiceTest {
	@InjectMocks
	private CabDriverServiceImpl cabDriverServiceImpl;
	
	@Mock
	private CabDriverRepository cabDriverRepository;
	
	@Test
	public void findAllCabs() {
		List<CabDriver> allCabDrivers =   cabDriverRepository.getDriverDetails();
		
		
	}
	
	
	public CabDriver givenCabDriver() {
		CabDriver cabDriver = new CabDriver();
		cabDriver.setName("Driver 1");
		cabDriver.setAge(23);
		cabDriver.setCarDetails("");
		cabDriver.setGender("M");
		cabDriver.setLocation(new Coordinate(23,34));
		return cabDriver;
	}
}
