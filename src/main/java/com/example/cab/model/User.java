package com.example.cab.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
	
	private int id;
    private String name;
    private String gender;
    private int age;
}
