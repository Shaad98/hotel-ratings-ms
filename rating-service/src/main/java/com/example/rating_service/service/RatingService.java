package com.example.rating_service.service;

import java.util.List;
import java.util.Optional;

import com.example.rating_service.model.Rating;

public interface RatingService {

    // Create
    Optional<Rating> createRating(Rating rating);

    // Get By ID
    Optional<Rating> getRatingById(String ratingId);

    // Get All
    List<Rating> getAllRatings();

    // Get All Ratings of User By userId
    List<Rating> getAllRatingsOfUser(String userId);

    // Get All Ratings of Hotel By hotelId
    List<Rating> getAllRatingsOfHotel(String hotelId);

}
