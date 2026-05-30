package com.example.rating_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.rating_service.model.Rating;



public interface RatingRepository extends JpaRepository<Rating,String>{

    List<Rating> findByUserId(String userId);

    List<Rating> findByHotelId(String hotelId);
}
