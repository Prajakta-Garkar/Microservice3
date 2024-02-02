package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingServiceImplementation implements RatingService{
	
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating createRating(Rating rating) {
		
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		
		return ratingRepository.findAll();
	}

	@Override
	public List<Rating> getUserById(String userId) {
		Optional<List<Rating>> ratingUserInfo=ratingRepository.findByUserId(userId);
		List<Rating> rating=null;
		if(ratingUserInfo.isPresent()) {
			rating=ratingUserInfo.get();
		}
		else {
			throw new RatingNotFoundException("Rating Not found....");
		}
		return rating;
		
	}

	@Override
	public List<Rating> getHotelById(String hotelId) {
		Optional<List<Rating>> ratingHotelInfo=ratingRepository.findByHotelId(hotelId);
		List<Rating> rating=null;
		if(ratingHotelInfo.isPresent()) {
			rating=ratingHotelInfo.get();
		}
		else {
			throw new RatingNotFoundException("Rating Not found....");
		}
		return rating;
	}
	

}
