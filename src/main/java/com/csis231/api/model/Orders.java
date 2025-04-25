package com.csis231.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
public class Orders implements Cloneable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "order_id", nullable = false)
    private Integer orderId;
    @Basic
    @Column(name = "order_number", nullable = false)
    private Integer orderNumber;
    @Basic
    @Column(name = "restaurant_id")
    private Integer restaurantId;
    @Basic
    @Column(name = "employee_id")
    private Integer employeeId;
    @Basic
    @Column(name = "food_id", nullable = false)
    private Integer foodId;

    @Basic
    @Column(name = "order_date", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp orderDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id", nullable = false, updatable = false, insertable = false)
    private Restaurant restaurantByRestaurantId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", nullable = false, updatable = false, insertable = false)
    private Employee employeeByEmployeeId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "food_id", referencedColumnName = "food_id", nullable = false, updatable = false, insertable = false)
    private Food foodByFoodId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (orderId != null ? !orderId.equals(orders.orderId) : orders.orderId != null) return false;
        if (orderNumber != null ? !orderNumber.equals(orders.orderNumber) : orders.orderNumber != null) return false;
        if (restaurantId != null ? !restaurantId.equals(orders.restaurantId) : orders.restaurantId != null)
            return false;
        if (employeeId != null ? !employeeId.equals(orders.employeeId) : orders.employeeId != null) return false;
        if (foodId != null ? !foodId.equals(orders.foodId) : orders.foodId != null) return false;
        if (orderDate != null ? !orderDate.equals(orders.orderDate) : orders.orderDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId != null ? orderId.hashCode() : 0;
        result = 31 * result + (orderNumber != null ? orderNumber.hashCode() : 0);
        result = 31 * result + (restaurantId != null ? restaurantId.hashCode() : 0);
        result = 31 * result + (employeeId != null ? employeeId.hashCode() : 0);
        result = 31 * result + (foodId != null ? foodId.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        return result;
    }

    public Restaurant getRestaurantByRestaurantId() {
        return restaurantByRestaurantId;
    }

    public void setRestaurantByRestaurantId(Restaurant restaurantByRestaurantId) {
        this.restaurantByRestaurantId = restaurantByRestaurantId;
    }

    public Employee getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }

    public Food getFoodByFoodId() {
        return foodByFoodId;
    }

    public void setFoodByFoodId(Food foodByFoodId) {
        this.foodByFoodId = foodByFoodId;
    }

    @Override
    public Orders clone() {
        try {
            Orders clone = (Orders) super.clone();
            clone.restaurantByRestaurantId = restaurantByRestaurantId.clone();
            clone.employeeByEmployeeId = employeeByEmployeeId.clone();
            clone.foodByFoodId = foodByFoodId.clone();

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
