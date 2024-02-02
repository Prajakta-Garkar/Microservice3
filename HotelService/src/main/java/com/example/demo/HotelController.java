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

@RequestMapping("/hotel")
@RestController
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/save")
	ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		Hotel hotel1=hotelService.createHotel(hotel);
		return ResponseEntity.ok(hotel1);
	}
	
	@GetMapping
	ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> hotel=hotelService.getAll();
		return ResponseEntity.ok(hotel);
		
	}
	
	@GetMapping("/{hotelId}")
	ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
		Hotel hotel=hotelService.getHotelById(hotelId);
		return ResponseEntity.ok(hotel);
	}

}
