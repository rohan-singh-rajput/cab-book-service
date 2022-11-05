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
        CabDriver cabDriver = new CabDriver("Rohan", "M", 23, "Swift, KA-01-12345", new Coordinate(12,13),true);
        driverList.add(cabDriver);
    }

    public CabDriver addCabDriver(CabDriver driver) {
        driverList.add(driver);
        return driver;
    }

    public List<CabDriver> getDriverDetails(){
        return driverList;
    }
}