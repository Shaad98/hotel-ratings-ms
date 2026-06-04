package com.example.hotel_service.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

import com.example.hotel_service.model.Hotel;

public interface HotelService {

    // Create
    Optional<Hotel> createHotel(Hotel hotel);

    // Get By ID
    Optional<Hotel> getHotelById(String hotelId);

    // Get All
    List<Hotel> getAllHotels();
}
