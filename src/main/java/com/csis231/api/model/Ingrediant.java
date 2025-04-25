package com.csis231.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Ingrediant implements Cloneable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ingrediant_id", nullable = false)
    private Integer ingrediantId;
    @Basic
    @Column(name = "food_id", nullable = true, insertable = false, updatable = false)
    private Integer foodId;
    @Basic
    @Column(name = "ingrediant_names_id", nullable = false, insertable = false, updatable = false)
    private Integer ingrediantNamesId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "food_id", referencedColumnName = "food_id")
    private Food foodByFoodId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ingrediant_names_id", referencedColumnName = "ingrediant_names_id", nullable = false)
    private IngrediantNames ingrediantNamesByIngrediantNamesId;

    public Integer getIngrediantId() {
        return ingrediantId;
    }

    public void setIngrediantId(Integer ingrediantId) {
        this.ingrediantId = ingrediantId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getIngrediantNamesId() {
        return ingrediantNamesId;
    }

    public void setIngrediantNamesId(Integer ingrediantNamesId) {
        this.ingrediantNamesId = ingrediantNamesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ingrediant that = (Ingrediant) o;

        if (ingrediantId != null ? !ingrediantId.equals(that.ingrediantId) : that.ingrediantId != null) return false;
        if (foodId != null ? !foodId.equals(that.foodId) : that.foodId != null) return false;
        if (ingrediantNamesId != null ? !ingrediantNamesId.equals(that.ingrediantNamesId) : that.ingrediantNamesId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ingrediantId != null ? ingrediantId.hashCode() : 0;
        result = 31 * result + (foodId != null ? foodId.hashCode() : 0);
        result = 31 * result + (ingrediantNamesId != null ? ingrediantNamesId.hashCode() : 0);
        return result;
    }

    public Food getFoodByFoodId() {
        return foodByFoodId;
    }

    public void setFoodByFoodId(Food foodByFoodId) {
        this.foodByFoodId = foodByFoodId;
    }

    public IngrediantNames getIngrediantNamesByIngrediantNamesId() {
        return ingrediantNamesByIngrediantNamesId;
    }

    public void setIngrediantNamesByIngrediantNamesId(IngrediantNames ingrediantNamesByIngrediantNamesId) {
        this.ingrediantNamesByIngrediantNamesId = ingrediantNamesByIngrediantNamesId;
    }

    @Override
    public Ingrediant clone() {
        try {
            Ingrediant clone = (Ingrediant) super.clone();
            clone.foodByFoodId = foodByFoodId.clone();
            clone.ingrediantNamesByIngrediantNamesId = ingrediantNamesByIngrediantNamesId.clone();

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
