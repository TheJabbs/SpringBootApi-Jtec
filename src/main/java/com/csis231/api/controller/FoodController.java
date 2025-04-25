package com.csis231.api.controller;

import com.csis231.api.DTO.FoodDto;
import com.csis231.api.model.Food;
import com.csis231.api.model.FoodCategory;
import com.csis231.api.model.Ingrediant;
import com.csis231.api.model.IngrediantNames;
import com.csis231.api.service.FoodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/foods")
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<Food> getAllFoods() {
        return foodService.getAllFoods();
    }

    @GetMapping("/fetchAll/{id}")
    public List<FoodDto> fetchAll(@PathVariable Integer id) {
        return foodService.findAllByRestaurantId(id).stream()
                .map(food -> {
                    FoodDto foodDto = new FoodDto();
                    foodDto.setFoodId(food.getFoodId());
                    foodDto.setRestaurantId(food.getRestaurantId());
                    foodDto.setFoodName(food.getFoodName());
                    foodDto.setFoodPrice(food.getFoodPrice());

                    food.getFoodCategoriesByFoodId().forEach(fcat ->
                            foodDto.getFoodCategories().add(fcat.getFoodCategoryCategory().charAt(0))
                    );

                    food.getIngrediantsByFoodId().forEach(ig ->
                            foodDto.getIngredients().add(ig.getIngrediantNamesByIngrediantNamesId().getIngrediantName())
                    );

                    return foodDto;
                })
                .collect(Collectors.toList());
    }

    @GetMapping("/foodName/{id}")
    public String getFoodName(@PathVariable Integer id) {
        Food food = foodService.getFoodById(Long.valueOf(id));
        return food.getFoodName();
    }

    @GetMapping("/foodPrice/{foodName}")
    public Double getFoodPrice(@PathVariable String foodName) {
        Food food = foodService.getFoodByFoodName(foodName);
        return food.getFoodPrice();
    }

    @PostMapping
    public ResponseEntity<Food> createFood(@Valid @RequestBody Food food) {
        Food savedFood = foodService.createFood(food);
        return new ResponseEntity<Food>(savedFood, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable Long id) {
        return ResponseEntity.ok(foodService.getFoodById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFood(@PathVariable Long id, @Valid @RequestBody Food foodDetails, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid food data");
        }
        Food updatedFood = foodService.updateFood(id, foodDetails);
        return ResponseEntity.ok(updatedFood);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable Long id) {
        foodService.deleteFood(id);
        return ResponseEntity.noContent().build();
    }
}