package com.example.cab.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "coordinatesTable")
public class Coordinate {
    private int x;
    private int y;
}
