package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private HotelService hotelService;
	private Logger logger = LoggerFactory.getLogger(UserServiceImplementation.class);

	@Override
	public User createUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public User getById(String userId) {
		Optional<User> userinfo = userRepository.findById(userId);
		User user = null;
		if (userinfo.isPresent()) {
			user = userinfo.get();
		} else {
			throw new UserNotFoundException("User not found");
		}
		// Fetch rating of the userId from RatingService
		// URL=http://localhost:8087/rating/user/4ce34ca7-dc53-4ef0-aa1a-6568b55266ee
		Rating[] forUserWithRating = restTemplate.getForObject("http://RATING-SERVICE/rating/user/" + user.getUserId(),
				Rating[].class);

		logger.info("{} ", forUserWithRating);
		List<Rating> ratings = Arrays.stream(forUserWithRating).toList();
		List<Rating> ratingList = ratings.stream().map(rating -> {
			System.out.println(rating.getHotelId());
			//ResponseEntity<Hotel> forObject = restTemplate
					//.getForEntity("http://HOTEL-SERVICE/hotel/" + rating.getHotelId(), Hotel.class);
//Hotel hotel=(Hotel)forObject.getBody();
					Hotel hotel=hotelService.getHotel(rating.getHotelId());
//logger.info("{} ",forObject);
rating.setHotel(hotel);
return rating;
		}).collect(Collectors.toList());

		user.setRating(ratingList);
		return user;
	}

	@Override
	public List<User> getAll() {

		return userRepository.findAll();
	}

}
