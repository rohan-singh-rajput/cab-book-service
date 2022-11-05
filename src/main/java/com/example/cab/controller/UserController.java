package com.example.cab.controller;

import com.example.cab.model.CabDriver;
import com.example.cab.model.RideDetails;
import com.example.cab.model.User;
import com.example.cab.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @PostMapping("/user")
    public User addUser(@RequestBody User user) {
        userServiceImpl.addUser(user);
        return user;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userServiceImpl.getUsers();
    }


}
