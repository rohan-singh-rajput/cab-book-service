package com.example.cab.repository;

import com.example.cab.model.User;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
	private static List<User> users = new ArrayList<User>();

	static {
		User user = new User("rohan", "M", 23);
		users.add(user);

		users.add(new User("Abhishek", "M", 23));
		users.add(new User("Rahul", "M", 29));
		users.add(new User("Nandini", "F", 22));
	}

	public User createUser(User user) {
		users.add(user);
		return user;
	}

	public List<User> getAllUsers() {
		return users;
	}

}