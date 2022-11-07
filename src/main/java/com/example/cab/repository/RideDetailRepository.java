package com.example.cab.repository;

import com.example.cab.model.Coordinate;
import com.example.cab.model.RideDetails;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RideDetailRepository {
	private static List<RideDetails> rideList = new ArrayList<>();

	static {
		RideDetails details = new RideDetails("rohan", new Coordinate(10, 20), new Coordinate(20, 40));
		rideList.add(details);
		RideDetails details2 = new RideDetails("rohan", new Coordinate(30, 40), new Coordinate(20, 10));
		rideList.add(details2);
	}

	public RideDetails saveRideDetails(RideDetails rideUser) {
		rideList.add(rideUser);
		return rideUser;
	}

	public List<RideDetails> getRideDetails() {
		return rideList;
	}
}