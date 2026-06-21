package com.example.user_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class RatingDTO {

    private String ratingId;
    private String userId;
    private String hotelId;
    private Integer rate;
    private String comment;

}
