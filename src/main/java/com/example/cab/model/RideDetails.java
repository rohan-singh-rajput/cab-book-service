package com.example.cab.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document("RideDetailsTable")
public class RideDetails {
	private int id;
    private String name;
    private Coordinate start;
    private Coordinate end;
}
