package com.example.hotel_service.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.hotel_service.model.Hotel;

public interface HotelRepository extends MongoRepository<Hotel,ObjectId>{

}
