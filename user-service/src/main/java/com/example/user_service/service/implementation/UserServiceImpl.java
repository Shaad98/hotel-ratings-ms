package com.example.user_service.service.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user_service.model.Hotel;
import com.example.user_service.model.Rating;
import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;
import com.example.user_service.service.UserService;
import com.example.user_service.service.external.HotelService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    @Override
    public Optional<User> createUser(User user) {
        return Optional.ofNullable(userRepository.save(user));
    }

    @Override
    public Optional<User> getUserById(String userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Rating[] ratingsArray = restTemplate.getForObject(
                "http://rating-service/ratings/users/" + userId,
                Rating[].class);

        List<Rating> ratings = Arrays.asList(ratingsArray);

        ratings.stream().forEach(rating -> {

            // Hotel hotel = restTemplate.getForObject(
            //         "http://hotel-service/hotels/" + rating.getHotelId(),
            //         Hotel.class);

            ResponseEntity<Hotel> response = hotelService.getHotelById(rating.getHotelId());

            Hotel hotel = response.getBody();

            rating.setHotel(hotel);
        });

        user.setRatings(ratings);

        return Optional.of(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
