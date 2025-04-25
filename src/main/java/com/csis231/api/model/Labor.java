package com.csis231.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
public class Labor implements Cloneable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "labor_id", nullable = false)
    private Integer laborId;
    @Basic
    @Column(name = "restaurant_id", nullable = false)
    private Integer restaurantId;
    @Basic
    @Column(name = "employee_id", nullable = false)
    private Integer employeeId;
    @Basic
    @Column(name = "labor_start", nullable = true)
    @CreationTimestamp
    private Timestamp laborStart;
    @Basic
    @Column(name = "labor_end", nullable = true)
    private Timestamp laborEnd;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id", nullable = false, updatable = false, insertable = false)
    private Restaurant restaurantByRestaurantId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", nullable = false, updatable = false, insertable = false)
    private Employee employeeByEmployeeId;

    public Integer getLaborId() {
        return laborId;
    }

    public void setLaborId(Integer laborId) {
        this.laborId = laborId;
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

    public Timestamp getLaborStart() {
        return laborStart;
    }

    public void setLaborStart(Timestamp laborStart) {
        this.laborStart = laborStart;
    }

    public Timestamp getLaborEnd() {
        return laborEnd;
    }

    public void setLaborEnd(Timestamp laborEnd) {
        this.laborEnd = laborEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Labor labor = (Labor) o;

        if (laborId != null ? !laborId.equals(labor.laborId) : labor.laborId != null) return false;
        if (restaurantId != null ? !restaurantId.equals(labor.restaurantId) : labor.restaurantId != null) return false;
        if (employeeId != null ? !employeeId.equals(labor.employeeId) : labor.employeeId != null) return false;
        if (laborStart != null ? !laborStart.equals(labor.laborStart) : labor.laborStart != null) return false;
        if (laborEnd != null ? !laborEnd.equals(labor.laborEnd) : labor.laborEnd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = laborId != null ? laborId.hashCode() : 0;
        result = 31 * result + (restaurantId != null ? restaurantId.hashCode() : 0);
        result = 31 * result + (employeeId != null ? employeeId.hashCode() : 0);
        result = 31 * result + (laborStart != null ? laborStart.hashCode() : 0);
        result = 31 * result + (laborEnd != null ? laborEnd.hashCode() : 0);
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

    @Override
    public Labor clone() {
        try {
            Labor clone = (Labor) super.clone();
            clone.restaurantByRestaurantId = restaurantByRestaurantId.clone();
            clone.employeeByEmployeeId = employeeByEmployeeId.clone();

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
