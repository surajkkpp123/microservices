package com.suraj.ratingservice.service.impl;

import com.suraj.ratingservice.model.Rating;
import com.suraj.ratingservice.repository.RatingRepository;
import com.suraj.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }

    @Override
    public Rating updateRating(Rating updateRating) {
        Rating rating = ratingRepository.findById(updateRating.getRatingId()).orElseThrow(
                       ()-> new RuntimeException("Rating not found with rating id - "+updateRating.getRatingId()));
        rating.setRating(updateRating.getRating());
        rating.setFeedback(updateRating.getFeedback());
        return ratingRepository.save(rating);
    }
}