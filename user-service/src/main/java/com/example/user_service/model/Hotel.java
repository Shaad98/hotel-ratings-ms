package com.example.user_service.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Hotel {

    private String hotelId;
    private String hotelName;
    private String location;
    private String about;

}
