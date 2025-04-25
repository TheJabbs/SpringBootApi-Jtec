package com.csis231.api.controller;

import com.csis231.api.model.FoodCategory;
import com.csis231.api.service.FoodCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("api/v1/foodcategorys")
public class FoodCategoryController {

    private final FoodCategoryService foodcategoryService;

    public FoodCategoryController(FoodCategoryService foodcategoryService) {
        this.foodcategoryService = foodcategoryService;
    }

    @GetMapping
    public List<FoodCategory> getAllFoodCategorys() {
        return foodcategoryService.getAllFoodCategorys();
    }

    @PostMapping
    public ResponseEntity<FoodCategory> createFoodCategory(@Valid @RequestBody FoodCategory foodcategory) {
        FoodCategory savedFoodCategory = foodcategoryService.createFoodCategory(foodcategory);
        return new ResponseEntity<FoodCategory>(savedFoodCategory, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodCategory> getFoodCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(foodcategoryService.getFoodCategoryById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFoodCategory(@PathVariable Long id, @Valid @RequestBody FoodCategory foodcategoryDetails, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid foodcategory data");
        }
        FoodCategory updatedFoodCategory = foodcategoryService.updateFoodCategory(id, foodcategoryDetails);
        return ResponseEntity.ok(updatedFoodCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodCategory(@PathVariable Long id) {
        foodcategoryService.deleteFoodCategory(id);
        return ResponseEntity.noContent().build();
    }
}