package com.csis231.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Food implements Cloneable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "food_id", nullable = false)
    private Integer foodId;
    @Basic
    @Column(name = "restaurant_id", nullable = false, updatable = false, insertable = false)
    private Integer restaurantId;
    @Basic
    @Column(name = "food_name", nullable = false, length = 20)
    private String foodName;
    @Basic
    @Column(name = "food_price", nullable = false, precision = 0)
    private Double foodPrice;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id", nullable = false)
    @JsonIgnore
    private Restaurant restaurantByRestaurantId;
    @OneToMany(mappedBy = "foodByFoodId")
    private Collection<FoodCategory> foodCategoriesByFoodId;
    @OneToMany(mappedBy = "foodByFoodId")
    private Collection<Ingrediant> ingrediantsByFoodId;

    @OneToMany(mappedBy = "foodByFoodId")
    @JsonIgnore
    private Collection<Orders> ordersByFoodId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Food food = (Food) o;

        if (foodId != null ? !foodId.equals(food.foodId) : food.foodId != null) return false;
        if (restaurantId != null ? !restaurantId.equals(food.restaurantId) : food.restaurantId != null) return false;
        if (foodName != null ? !foodName.equals(food.foodName) : food.foodName != null) return false;
        if (foodPrice != null ? !foodPrice.equals(food.foodPrice) : food.foodPrice != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = foodId != null ? foodId.hashCode() : 0;
        result = 31 * result + (restaurantId != null ? restaurantId.hashCode() : 0);
        result = 31 * result + (foodName != null ? foodName.hashCode() : 0);
        result = 31 * result + (foodPrice != null ? foodPrice.hashCode() : 0);
        return result;
    }

    public Restaurant getRestaurantByRestaurantId() {
        return restaurantByRestaurantId;
    }

    public void setRestaurantByRestaurantId(Restaurant restaurantByRestaurantId) {
        this.restaurantByRestaurantId = restaurantByRestaurantId;
    }

    public Collection<FoodCategory> getFoodCategoriesByFoodId() {
        return foodCategoriesByFoodId;
    }

    public void setFoodCategoriesByFoodId(Collection<FoodCategory> foodCategoriesByFoodId) {
        this.foodCategoriesByFoodId = foodCategoriesByFoodId;
    }

    public Collection<Ingrediant> getIngrediantsByFoodId() {
        return ingrediantsByFoodId;
    }

    public void setIngrediantsByFoodId(Collection<Ingrediant> ingrediantsByFoodId) {
        this.ingrediantsByFoodId = ingrediantsByFoodId;
    }

    public Collection<Orders> getOrdersByFoodId() {
        return ordersByFoodId;
    }

    public void setOrdersByFoodId(Collection<Orders> ordersByFoodId) {
        this.ordersByFoodId = ordersByFoodId;
    }

    @Override
    public Food clone() {
        try {
            Food clone = (Food) super.clone();
            clone.setFoodId(this.foodId);
            clone.setRestaurantId(this.restaurantId);
            clone.setFoodName(this.foodName);
            clone.setFoodPrice(this.foodPrice);
            clone.setRestaurantByRestaurantId(this.restaurantByRestaurantId);
            clone.setFoodCategoriesByFoodId(this.foodCategoriesByFoodId);
            clone.setIngrediantsByFoodId(this.ingrediantsByFoodId);
            clone.setOrdersByFoodId(this.ordersByFoodId);

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
