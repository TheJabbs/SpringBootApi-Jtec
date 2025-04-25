package com.csis231.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "food_category", schema = "pos_db")
public class FoodCategory implements Cloneable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "food_category_id", nullable = false)
    private Integer foodCategoryId;
    @Basic
    @Column(name = "food_id", nullable = false, insertable = false, updatable = false)
    private Integer foodId;
    @Basic
    @JsonIgnore
    @Column(name = "food_category_category", nullable = false, length = 1)
    private String foodCategoryCategory;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", referencedColumnName = "food_id", nullable = false)
    @JsonIgnore
    private Food foodByFoodId;

    public Integer getFoodCategoryId() {
        return foodCategoryId;
    }

    public void setFoodCategoryId(Integer foodCategoryId) {
        this.foodCategoryId = foodCategoryId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public String getFoodCategoryCategory() {
        return foodCategoryCategory;
    }

    public void setFoodCategoryCategory(String foodCategoryCategory) {
        this.foodCategoryCategory = foodCategoryCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodCategory that = (FoodCategory) o;

        if (foodCategoryId != null ? !foodCategoryId.equals(that.foodCategoryId) : that.foodCategoryId != null)
            return false;
        if (foodId != null ? !foodId.equals(that.foodId) : that.foodId != null) return false;
        if (foodCategoryCategory != null ? !foodCategoryCategory.equals(that.foodCategoryCategory) : that.foodCategoryCategory != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = foodCategoryId != null ? foodCategoryId.hashCode() : 0;
        result = 31 * result + (foodId != null ? foodId.hashCode() : 0);
        result = 31 * result + (foodCategoryCategory != null ? foodCategoryCategory.hashCode() : 0);
        return result;
    }

    public Food getFoodByFoodId() {
        return foodByFoodId;
    }

    public void setFoodByFoodId(Food foodByFoodId) {
        this.foodByFoodId = foodByFoodId;
    }

    @Override
    public FoodCategory clone() {
        try {
            FoodCategory clone = (FoodCategory) super.clone();
            clone.foodByFoodId = foodByFoodId.clone();

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
