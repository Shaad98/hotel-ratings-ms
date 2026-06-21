package com.example.user_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.example.user_service.dto.RatingDTO;
// import com.example.user_service.model.Rating;
import com.example.user_service.service.external.RatingService;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	private RatingService ratingService;

	@Test
	void contextLoads() {
	}

	@Test
	void createRating(){

		ResponseEntity<RatingDTO> rating= ratingService.createRating(RatingDTO.builder().rate(4).comment("Good Service Provide Here").userId("97d42d6d-0419-41a6-8d2a-d0d70f6e75d3").hotelId("ab0f4cd8-d70e-40be-a0a2-61ed533c8db5").build()); 

		System.out.println(rating);
	}
}
