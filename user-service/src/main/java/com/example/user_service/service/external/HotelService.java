package com.example.user_service.service.external;

import org.springframework.cloud.openfeign.FeignClient;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;

// import com.example.user_service.model.Hotel;

@FeignClient(name = "hotel-service")
public interface HotelService {

    // @GetMapping("/hotels/{id}")
    // ResponseEntity<Hotel> getHotelById(@PathVariable("id") String hotelId);
}
