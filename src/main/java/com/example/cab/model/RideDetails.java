package com.example.cab.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RideDetails {
    private String name;
    private Coordinate start;
    private Coordinate end;
}
