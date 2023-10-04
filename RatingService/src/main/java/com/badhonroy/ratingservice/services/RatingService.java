package com.badhonroy.ratingservice.services;

import com.badhonroy.ratingservice.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {
    Rating create (Rating rating);

    List<Rating> getAllRatings ();
    List<Rating> getRatingsByUserId(String userId);
    List<Rating> getRatingsByHotelId (String hotelId);


}
