package com.example.user_service.service.implementation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.user_service.model.Hotel;
import com.example.user_service.model.Rating;
import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;
import com.example.user_service.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Optional<User> createUser(User user) {
        return Optional.ofNullable(userRepository.save(user));
    }

    @Override
    public Optional<User> getUserById(String userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Rating[] ratingsArray = restTemplate.getForObject(
                "http://localhost:8082/ratings/users/" + userId,
                Rating[].class);

        List<Rating> ratings = Arrays.asList(ratingsArray);

        ratings.stream().forEach(rating -> {

            Hotel hotel = restTemplate.getForObject(
                    "http://localhost:8081/hotel/" + rating.getHotelId(),
                    Hotel.class);

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
