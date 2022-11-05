package com.example.cab.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CabDriver {
    private String name;
    private String gender;
    private int age;
    private String carDetails;
    private Coordinate location;

    @JsonIgnore
    @JsonIgnoreProperties
    private boolean available = true;
}
