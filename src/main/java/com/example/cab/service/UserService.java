package com.example.cab.service;

import com.example.cab.model.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);

    public List<User> getUsers();

}
