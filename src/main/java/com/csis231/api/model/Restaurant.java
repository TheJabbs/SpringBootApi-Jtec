package com.csis231.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Restaurant implements Cloneable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "restaurant_id", nullable = false)
    private Integer restaurantId;
    @Basic
    @Column(name = "restaurant_token", nullable = true, length = 30, updatable = false, insertable = false)
    private String restaurantToken;
    @Basic
    @Column(name = "restaurant_name", nullable = false, length = 30)
    private String restaurantName;
    @Basic
    @Column(name = "restaurant_address", nullable = false, length = 30)
    private String restaurantAddress;
    @Basic
    @Column(name = "restaurant_phone", nullable = false)
    private Integer restaurantPhone;
    @Basic
    @Column(name = "restaurant_Drates", nullable = false, precision = 0)
    private Double restaurantDrates;
    @OneToMany(mappedBy = "restaurantByRestaurantId")
    @JsonIgnore
    private Collection<Employee> employeesByRestaurantId;
    @OneToMany(mappedBy = "restaurantByRestaurantId")

    private Collection<Food> foodsByRestaurantId;
    @OneToMany(mappedBy = "restaurantByRestaurantId")
    private Collection<Labor> laborsByRestaurantId;
    @OneToMany(mappedBy = "restaurantByRestaurantId")
    private Collection<Orders> ordersByRestaurantId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "restaurant_token", referencedColumnName = "token")
    private Token tokenByRestaurantToken;

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getRestaurantToken() {
        return restaurantToken;
    }

    public void setRestaurantToken(String restaurantToken) {
        this.restaurantToken = restaurantToken;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public Integer getRestaurantPhone() {
        return restaurantPhone;
    }

    public void setRestaurantPhone(Integer restaurantPhone) {
        this.restaurantPhone = restaurantPhone;
    }

    public Double getRestaurantDrates() {
        return restaurantDrates;
    }

    public void setRestaurantDrates(Double restaurantDrates) {
        this.restaurantDrates = restaurantDrates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Restaurant that = (Restaurant) o;

        if (restaurantId != null ? !restaurantId.equals(that.restaurantId) : that.restaurantId != null) return false;
        if (restaurantToken != null ? !restaurantToken.equals(that.restaurantToken) : that.restaurantToken != null)
            return false;
        if (restaurantName != null ? !restaurantName.equals(that.restaurantName) : that.restaurantName != null)
            return false;
        if (restaurantAddress != null ? !restaurantAddress.equals(that.restaurantAddress) : that.restaurantAddress != null)
            return false;
        if (restaurantPhone != null ? !restaurantPhone.equals(that.restaurantPhone) : that.restaurantPhone != null)
            return false;
        if (restaurantDrates != null ? !restaurantDrates.equals(that.restaurantDrates) : that.restaurantDrates != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = restaurantId != null ? restaurantId.hashCode() : 0;
        result = 31 * result + (restaurantToken != null ? restaurantToken.hashCode() : 0);
        result = 31 * result + (restaurantName != null ? restaurantName.hashCode() : 0);
        result = 31 * result + (restaurantAddress != null ? restaurantAddress.hashCode() : 0);
        result = 31 * result + (restaurantPhone != null ? restaurantPhone.hashCode() : 0);
        result = 31 * result + (restaurantDrates != null ? restaurantDrates.hashCode() : 0);
        return result;
    }

    public Collection<Employee> getEmployeesByRestaurantId() {
        return employeesByRestaurantId;
    }

    public void setEmployeesByRestaurantId(Collection<Employee> employeesByRestaurantId) {
        this.employeesByRestaurantId = employeesByRestaurantId;
    }

    public Collection<Food> getFoodsByRestaurantId() {
        return foodsByRestaurantId;
    }

    public void setFoodsByRestaurantId(Collection<Food> foodsByRestaurantId) {
        this.foodsByRestaurantId = foodsByRestaurantId;
    }

    public Collection<Labor> getLaborsByRestaurantId() {
        return laborsByRestaurantId;
    }

    public void setLaborsByRestaurantId(Collection<Labor> laborsByRestaurantId) {
        this.laborsByRestaurantId = laborsByRestaurantId;
    }

    public Collection<Orders> getOrdersByRestaurantId() {
        return ordersByRestaurantId;
    }

    public void setOrdersByRestaurantId(Collection<Orders> ordersByRestaurantId) {
        this.ordersByRestaurantId = ordersByRestaurantId;
    }

    public Token getTokenByRestaurantToken() {
        return tokenByRestaurantToken;
    }

    public void setTokenByRestaurantToken(Token tokenByRestaurantToken) {
        this.tokenByRestaurantToken = tokenByRestaurantToken;
    }

    @Override
    public Restaurant clone() {
        try {
            Restaurant clone = (Restaurant) super.clone();
            clone.setRestaurantId(this.restaurantId);
            clone.setRestaurantToken(this.restaurantToken);
            clone.setRestaurantName(this.restaurantName);
            clone.setRestaurantAddress(this.restaurantAddress);
            clone.setRestaurantPhone(this.restaurantPhone);
            clone.setRestaurantDrates(this.restaurantDrates);
            clone.setEmployeesByRestaurantId(this.employeesByRestaurantId);
            clone.setFoodsByRestaurantId(this.foodsByRestaurantId);
            clone.setLaborsByRestaurantId(this.laborsByRestaurantId);
            clone.setOrdersByRestaurantId(this.ordersByRestaurantId);
            clone.setTokenByRestaurantToken(this.tokenByRestaurantToken);

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
