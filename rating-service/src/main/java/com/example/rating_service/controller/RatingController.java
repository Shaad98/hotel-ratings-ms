package com.example.rating_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rating_service.model.Rating;
import com.example.rating_service.service.RatingService;


@RestController
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
    {
        Optional<Rating> savedRating = ratingService.createRating(rating);

        return savedRating.isPresent() ? ResponseEntity.status(HttpStatus.CREATED).body(savedRating.get()) :
                ResponseEntity.internalServerError().build();
    }

    @GetMapping("/{ratingId}")
    public ResponseEntity<Rating> getRatingById(String ratingId){

        return ratingService.getRatingById(ratingId).map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings()
    {
        return ResponseEntity.ok(ratingService.getAllRatings());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable("id") String userId) {
        return ResponseEntity.ok(ratingService.getAllRatingsOfUser(userId));
    }

    @GetMapping("/hotel/{id}")
    public ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable("id") String hotelId) {
        return ResponseEntity.ok(ratingService.getAllRatingsOfHotel(hotelId));
    }
    
    
}
