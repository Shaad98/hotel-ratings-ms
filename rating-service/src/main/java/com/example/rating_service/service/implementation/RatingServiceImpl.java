package com.example.rating_service.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.rating_service.model.Rating;
import com.example.rating_service.repository.RatingRepository;
import com.example.rating_service.service.RatingService;

@Service
public class  RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    

    @Override
    public Optional<Rating> createRating(Rating rating) {
        return Optional.ofNullable(ratingRepository.save(rating));
    }

    @Override
    public Optional<Rating> getRatingById(String ratingId) {
        return ratingRepository.findById(ratingId);
    }

    @Override
    public List<Rating> getAllRatings() {
       return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getAllRatingsOfUser(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingsOfHotel(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

}
