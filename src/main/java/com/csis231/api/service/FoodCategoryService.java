package com.csis231.api.service;

import com.csis231.api.exception.ResourceNotFoundException;
import com.csis231.api.model.FoodCategory;
import com.csis231.api.repository.FoodCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FoodCategoryService {

    private final FoodCategoryRepository foodcategoryRepository;

    @Autowired
    public FoodCategoryService(FoodCategoryRepository foodcategoryRepository) {
        this.foodcategoryRepository = foodcategoryRepository;
    }

    public List<FoodCategory> getAllFoodCategorys() {
        return foodcategoryRepository.findAll();
    }

    public FoodCategory getFoodCategoryById(Long id) {
        return foodcategoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("FoodCategory not found"));
    }

    public FoodCategory createFoodCategory(FoodCategory foodcategory) {
        return foodcategoryRepository.save(foodcategory);
    }

    public FoodCategory updateFoodCategory(Long id, FoodCategory foodCategoryDetails) {
        FoodCategory foodCategory = foodcategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food category not found with id : " + id));

        foodCategory = foodCategoryDetails.clone();

        return foodcategoryRepository.save(foodCategory);
    }

    public Map<String, Boolean> deleteFoodCategory(Long id) {
        Optional<FoodCategory> optionalFoodCategory = foodcategoryRepository.findById(id);
        if (optionalFoodCategory.isEmpty()) {
            throw new ResourceNotFoundException("Food category not found with id : " + id);
        }

        foodcategoryRepository.deleteById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}