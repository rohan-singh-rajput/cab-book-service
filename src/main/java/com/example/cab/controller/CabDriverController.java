package com.example.cab.controller;

import com.example.cab.Utils.UserNotFoundException;
import com.example.cab.model.CabDriver;
import com.example.cab.model.ChooseRide;
import com.example.cab.model.RideDetails;
import com.example.cab.service.CabBookServiceImpl;
import com.example.cab.service.CabDriverServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CabDriverController {

	@Autowired
	private CabDriverServiceImpl cabDriverService;
	@Autowired
	private CabBookServiceImpl cabBookService;

	@PostMapping("/cab")
	public CabDriver addCabDriver(@RequestBody CabDriver cabDriver) {
		cabDriverService.createCabDriver(cabDriver);
		return cabDriver;
	}

	@GetMapping("/cabs")
	public List<CabDriver> getCabDrivers() {
		return cabDriverService.getAllCabDrivers();
	}

	@PostMapping("/find_rides")
	public List<CabDriver> findRides(@RequestBody RideDetails rideDetails) throws UserNotFoundException {
		return cabBookService.findRides(rideDetails);
	}

	@PostMapping("/choose_ride")
	public String chooseRide(@RequestBody ChooseRide ride) {
		return cabBookService.chooseRide(ride);
	}

}
