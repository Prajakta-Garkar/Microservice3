package com.example.demo;

import java.util.List;

public interface RatingService {

	Rating createRating(Rating rating);
	List<Rating> getAllRating();
	List<Rating> getUserById(String userId);
	List<Rating> getHotelById(String hotelId);
}
