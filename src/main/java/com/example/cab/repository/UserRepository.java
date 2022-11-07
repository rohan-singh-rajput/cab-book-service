package com.example.cab.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.cab.model.User;

public interface UserRepository extends MongoRepository<User,Integer> {
}
