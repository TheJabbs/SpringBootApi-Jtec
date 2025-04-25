package com.csis231.api.DTO;

import java.util.ArrayList;
import java.util.List;

public class FoodDto {
    private Integer foodId;
    private Integer restaurantId;
    private String foodName;
    private Double foodPrice;
    private List<Character> foodCategories;  // Assuming you want simple identifiers or types as characters
    private List<String> ingredients;  // Just the names of the ingredients

    // Constructors, getters, and setters
    public FoodDto() {
        this.foodCategories = new ArrayList<>();
        this.ingredients = new ArrayList<>();
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    public List<Character> getFoodCategories() {
        return foodCategories;
    }

    public void setFoodCategories(List<Character> foodCategories) {
        this.foodCategories = foodCategories;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}


