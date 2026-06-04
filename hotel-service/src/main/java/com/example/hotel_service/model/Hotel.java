package com.example.hotel_service.model;

// import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "hotels")
public class Hotel {

    @Id
    // private ObjectId hotelId;
    private String hotelId;
    private String hotelName;
    private String location;
    private String about;

}
