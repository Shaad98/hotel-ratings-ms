package com.example.user_service.service.external;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.user_service.model.Rating;

@FeignClient(name = "rating-service")
public interface RatingService {

    @GetMapping("/ratings/{id}")
    ResponseEntity<Rating> getRatingsByRatingID(@PathVariable("id") String ratingId);

    @GetMapping("/ratings/users/{id}")
    ResponseEntity<List<Rating>> getAllRatingsOfUserByUserId(@PathVariable("id") String userId);
}
