package com.example.cab.service;

import com.example.cab.model.CabDriver;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CabDriverService {
    public CabDriver createCabDriver(CabDriver cabDriver);

    public List<CabDriver> getAllCabDrivers();
}
