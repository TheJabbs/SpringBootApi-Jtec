package com.csis231.api.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
public class Orderlist implements Cloneable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "orderList_id", nullable = false)
    private Integer orderListId;
    @Basic
    @Column(name = "food", nullable = false, length = 150)
    private String food;

    @Basic
    @CreationTimestamp
    @Column(name = "orderList_time", nullable = true)
    private Timestamp orderListTime;

    public Orderlist() {
    }

    public Orderlist(String food) {
        this.food = food;;
    }

    public Integer getOrderListId() {
        return orderListId;
    }

    public void setOrderListId(Integer orderListId) {
        this.orderListId = orderListId;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public Timestamp getOrderListTime() {
        return orderListTime;
    }

    public void setOrderListTime(Timestamp orderListTime) {
        this.orderListTime = orderListTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orderlist orderlist = (Orderlist) o;

        if (orderListId != null ? !orderListId.equals(orderlist.orderListId) : orderlist.orderListId != null)
            return false;
        if (food != null ? !food.equals(orderlist.food) : orderlist.food != null) return false;
        if (orderListTime != null ? !orderListTime.equals(orderlist.orderListTime) : orderlist.orderListTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderListId != null ? orderListId.hashCode() : 0;
        result = 31 * result + (food != null ? food.hashCode() : 0);
        result = 31 * result + (orderListTime != null ? orderListTime.hashCode() : 0);
        return result;
    }

    @Override
    public Orderlist clone() {
        try {
            Orderlist clone = (Orderlist) super.clone();


            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
