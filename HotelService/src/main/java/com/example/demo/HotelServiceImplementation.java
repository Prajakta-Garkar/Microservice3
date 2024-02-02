package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImplementation implements HotelService
{

	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel createHotel(Hotel hotel) {
		
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getHotelById(String hotelId) {
		Optional<Hotel> hotelInfo=hotelRepository.findById(hotelId);
		Hotel hotel=null;
		if(hotelInfo.isPresent()) {
			hotel=hotelInfo.get();
		}
		else {
			throw new HotelNotFoundException("Hotel not found..");
		}
		
		return hotel;
	}
	
}
