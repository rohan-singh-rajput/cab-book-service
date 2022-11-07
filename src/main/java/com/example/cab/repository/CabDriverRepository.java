package com.example.cab.repository;

import com.example.cab.model.CabDriver;
import com.example.cab.model.Coordinate;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CabDriverRepository {
	private static List<CabDriver> driverList = new ArrayList<CabDriver>();

	static {
		CabDriver cabDriver = new CabDriver("Rohan", "M", 23, "Swift, KA-01-12345", new Coordinate(12, 13), true);
		driverList.add(cabDriver);

		driverList.add(new CabDriver("Driver1", "M", 22, "Swift, KA-01-12345", new Coordinate(10, 1), true));
		driverList.add(new CabDriver("Driver2", "M", 29, "Swift, KA-01-12345", new Coordinate(11, 10), true));
		driverList.add(new CabDriver("Driver3", "M", 24, "Swift, KA-01-12345", new Coordinate(5, 3), true));
	}

	public CabDriver addCabDriver(CabDriver driver) {
		driverList.add(driver);
		return driver;
	}

	public List<CabDriver> getDriverDetails() {
		return driverList;
	}
}