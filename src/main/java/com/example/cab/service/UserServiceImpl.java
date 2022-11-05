package com.example.cab.service;

import com.example.cab.model.User;
import com.example.cab.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements  UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.createUser(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.getAllUsers();
    }
}
