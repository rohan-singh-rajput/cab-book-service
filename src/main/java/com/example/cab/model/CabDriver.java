package com.example.cab.model;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "CabDrivers")
public class CabDriver {
	private int id;
    private String name;
    private String gender;
    private int age;
    private String carDetails;
    private Coordinate location;

    @JsonIgnore
    @JsonIgnoreProperties
    private boolean available = true;
}
