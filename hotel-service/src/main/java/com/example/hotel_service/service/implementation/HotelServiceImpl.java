package com.example.hotel_service.service.implementation;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel_service.model.Hotel;
import com.example.hotel_service.repository.HotelRepository;
import com.example.hotel_service.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Optional<Hotel> createHotel(Hotel hotel) {
      return Optional.ofNullable(hotelRepository.save(hotel));
    }

    @Override
    public Optional<Hotel> getHotelById(ObjectId hotelId) {
       return hotelRepository.findById(hotelId);
    }

    @Override
    public List<Hotel> getAllHotels() {
       return hotelRepository.findAll();
    }

}
