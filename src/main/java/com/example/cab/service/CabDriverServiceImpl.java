package com.example.cab.service;

import com.example.cab.model.CabDriver;
import com.example.cab.repository.CabDriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CabDriverServiceImpl  implements  CabDriverService{
    @Autowired
    private CabDriverRepository cabDriverRepository;

    @Override
    public CabDriver createCabDriver(CabDriver cabDriver) {
        return cabDriverRepository.addCabDriver(cabDriver);
    }

    @Override
    public List<CabDriver> getAllCabDrivers() {
        return cabDriverRepository.getDriverDetails();
    }
}
