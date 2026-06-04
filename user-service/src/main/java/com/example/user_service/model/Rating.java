package com.example.user_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Rating {

    private String ratingId;
    private String userId;
    private String hotelId;
    private Integer rate;
    private String comment;
    
    private Hotel hotel;
}
