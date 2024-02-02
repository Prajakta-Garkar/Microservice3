package com.example.demo;

import java.util.List;

public interface HotelService {
	Hotel createHotel(Hotel hotel);
	List<Hotel> getAll();
	Hotel getHotelById(String hotelId);

}
