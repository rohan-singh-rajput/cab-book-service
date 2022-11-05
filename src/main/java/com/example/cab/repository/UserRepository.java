package com.example.cab.repository;


import com.example.cab.model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private static List<User> users = new ArrayList<User>();

    static {
        User user = new User("rohan","M" , 23);
        users.add(user);
    }

    public User createUser(User user) {
        users.add(user);
        return user;
    }

    public List<User> getAllUsers(){
        return users;
    }

}