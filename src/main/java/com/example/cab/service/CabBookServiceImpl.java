package com.example.cab.service;

import com.example.cab.Utils.UserNotFoundException;
import com.example.cab.model.CabDriver;
import com.example.cab.model.ChooseRide;
import com.example.cab.model.Coordinate;
import com.example.cab.model.RideDetails;
import com.example.cab.model.User;
import com.example.cab.repository.CabDriverRepository;
import com.example.cab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CabBookServiceImpl implements CabBookService {

	private List<CabDriver> availableCabs = new ArrayList<>();

	@Autowired
	private CabDriverRepository cabDriverRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<RideDetails> getAllRideDetails() {
		return null;
	}

	@Override
	public List<CabDriver> findRides(RideDetails rideDetails) throws UserNotFoundException {
		if (!ifUserAvailable(rideDetails.getName())) {
			throw new UserNotFoundException("User Not Found");
		}

		for (CabDriver cabs : cabDriverRepository.getDriverDetails()) {
			if (distanceBetweenEndPoints(rideDetails.getStart(), cabs.getLocation()) <= 5 && cabs.isAvailable()) {
				availableCabs.add(cabs);
			}
		}
		return availableCabs;
	}

	public Double distanceBetweenEndPoints(Coordinate user, Coordinate cab) {
		return Math.sqrt((cab.getY() - user.getY()) * (cab.getY() - user.getY())
				+ ((cab.getX() - user.getX()) * (cab.getX() - user.getX())));
	}

	public boolean ifUserAvailable(String name) {
		for (User user : userRepository.getAllUsers()) {
			if (user.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String chooseRide(ChooseRide ride) {
		if (ifUserAvailable(ride.getUserName())) {
			for (CabDriver cab : availableCabs) {
				if (cab.getName().equals(ride.getCabDriverName())) {
					cab.setAvailable(false);
					availableCabs.remove(cab);
					return "Booked by " + ride.getUserName() + " " + ride.getCabDriverName();
				}
			}
		}
		return "No Nearby Cabs Found";
	}
}