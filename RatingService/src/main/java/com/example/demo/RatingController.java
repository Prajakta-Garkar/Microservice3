package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rating")
@RestController
public class RatingController {

	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/save")
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
		Rating rating1=ratingService.createRating(rating);
		return ResponseEntity.ok(rating1);
	}
	
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings(){
		List<Rating> rating=ratingService.getAllRating();
		return ResponseEntity.ok(rating);
	}
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
		List<Rating> rating= ratingService.getUserById(userId);
		return ResponseEntity.ok(rating);
		
	}
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
		List<Rating> rating=ratingService.getHotelById(hotelId);
		return ResponseEntity.ok(rating);
	}
}
