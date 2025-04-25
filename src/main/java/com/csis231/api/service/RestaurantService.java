package com.csis231.api.service;

import com.csis231.api.exception.ResourceNotFoundException;
import com.csis231.api.model.Restaurant;
import com.csis231.api.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public Restaurant getRestaurantByToken(String token) {
        return restaurantRepository.findRestaurantByTokenAndTokenNotExpired(token);
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public Restaurant updateRestaurant(Long id, Restaurant restaurantDetails) {
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id : " + id));

        restaurant = restaurantDetails.clone();


        return restaurantRepository.save(restaurant);
    }

    public Map<String, Boolean> deleteRestaurant(Long id) {
        Optional<Restaurant> optionalRestaurant = restaurantRepository.findById(id);
        if (optionalRestaurant.isEmpty()) {
            throw new ResourceNotFoundException("Restaurant not found with id : " + id);
        }

        restaurantRepository.deleteById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}