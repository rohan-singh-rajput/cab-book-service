package com.example.cab.service;

import com.example.cab.Utils.UserNotFoundException;
import com.example.cab.model.CabDriver;
import com.example.cab.model.ChooseRide;
import com.example.cab.model.RideDetails;
import java.util.List;

public interface CabBookService {
//    public RideDetails saveRideDetails(RideDetails rideDetails);

    public List<RideDetails> getAllRideDetails();

    public List<CabDriver> findRides(RideDetails rideDetails) throws UserNotFoundException;
    
    public String chooseRide(ChooseRide ride);
}
