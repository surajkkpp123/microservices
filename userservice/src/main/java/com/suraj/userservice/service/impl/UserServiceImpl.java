package com.suraj.userservice.service.impl;

import com.suraj.userservice.exception.ResourceNotFoundException;
import com.suraj.userservice.model.Hotel;
import com.suraj.userservice.model.Rating;
import com.suraj.userservice.model.User;
import com.suraj.userservice.proxy.HotelServiceProxy;
import com.suraj.userservice.proxy.RatingServiceProxy;
import com.suraj.userservice.repository.UserRepository;
import com.suraj.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RatingServiceProxy ratingServiceProxy;
    @Autowired
    private HotelServiceProxy hotelServiceProxy;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(
                   ()->new ResourceNotFoundException("Resource not found with id - "+userId));
        //calling rating service
        ResponseEntity<List<Rating>> response = ratingServiceProxy.getRatingsByUserId(user.getUserId());

        if (response.getStatusCode() == HttpStatus.OK) {
           List<Rating> ratings = response.getBody().stream().map(rating -> {

               //calling hotel-service
                ResponseEntity<Hotel> hotelResponseEntity = hotelServiceProxy.getHotel(rating.getHotelId());

                return rating;
            }).collect(Collectors.toList());
            user.setRatings(ratings);
        } else {
            throw new RuntimeException("Failed to get ratings for user " + userId);
        }

        return user;
    }
}