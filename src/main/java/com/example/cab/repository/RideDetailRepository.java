package com.example.cab.repository;

import com.example.cab.model.Coordinate;
import com.example.cab.model.RideDetails;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface RideDetailRepository extends MongoRepository<RideDetails, Integer>{
}