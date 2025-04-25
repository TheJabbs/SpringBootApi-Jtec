package com.csis231.api.repository;

import com.csis231.api.DTO.FoodDto;
import com.csis231.api.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodRepository extends JpaRepository<Food, Long> {

    List<Food> findAllByRestaurantId(Integer id);
    Food getFoodByFoodName(String food);

}
