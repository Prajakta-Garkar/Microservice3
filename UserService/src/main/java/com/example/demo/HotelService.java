package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.Hotel;

@FeignClient(name="HOTEL-SERVICE")
public interface HotelService {
	
	@GetMapping("hotel/{hotelId}")
	Hotel getHotel(@PathVariable String hotelId);  

}
