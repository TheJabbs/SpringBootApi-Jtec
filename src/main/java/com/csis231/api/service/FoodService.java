package com.csis231.api.service;

import com.csis231.api.exception.ResourceNotFoundException;
import com.csis231.api.model.Food;
import com.csis231.api.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    public Food getFoodById(Long id) {
        return foodRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Food not found"));
    }
    public Food getFoodByFoodName(String food) {
        return foodRepository.getFoodByFoodName(food);
    }

    public Food createFood(Food food) {
        return foodRepository.save(food);
    }

    public Food updateFood(Long id, Food foodDetails) {
        Food food = foodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found with id : " + id));

        food = foodDetails.clone();

        return foodRepository.save(food);
    }

    public Map<String, Boolean> deleteFood(Long id) {
        Optional<Food> optionalFood = foodRepository.findById(id);
        if (optionalFood.isEmpty()) {
            throw new ResourceNotFoundException("Food not found with id : " + id);
        }

        foodRepository.deleteById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    public List<Food> findAllByRestaurantId(int i) {
        return foodRepository.findAllByRestaurantId(i);
    }
}