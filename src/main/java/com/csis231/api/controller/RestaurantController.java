package com.csis231.api.controller;

import com.csis231.api.model.Restaurant;
import com.csis231.api.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("api/v1/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/token/{token}")
    public ResponseEntity<Restaurant> getRestaurantByToken(@PathVariable String token) {
        return ResponseEntity.ok(restaurantService.getRestaurantByToken(token));
    }

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(@Valid @RequestBody Restaurant restaurant) {
        Restaurant savedRestaurant = restaurantService.createRestaurant(restaurant);
        return new ResponseEntity<Restaurant>(savedRestaurant, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Long id) {
        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateRestaurant(@PathVariable Long id, @Valid @RequestBody Restaurant restaurantDetails, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid restaurant data");
        }
        Restaurant updatedRestaurant = restaurantService.updateRestaurant(id, restaurantDetails);
        return ResponseEntity.ok(updatedRestaurant);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }
}