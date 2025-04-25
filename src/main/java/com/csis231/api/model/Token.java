package com.csis231.api.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Token implements Cloneable{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "token", nullable = false, length = 30)
    private String token;
    @Basic
    @Column(name = "token_expire", nullable = true)
    private Timestamp tokenExpire;
    @OneToMany(mappedBy = "tokenByRestaurantToken")
    private Collection<Restaurant> restaurantsByToken;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getTokenExpire() {
        return tokenExpire;
    }

    public void setTokenExpire(Timestamp tokenExpire) {
        this.tokenExpire = tokenExpire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token1 = (Token) o;

        if (token != null ? !token.equals(token1.token) : token1.token != null) return false;
        if (tokenExpire != null ? !tokenExpire.equals(token1.tokenExpire) : token1.tokenExpire != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = token != null ? token.hashCode() : 0;
        result = 31 * result + (tokenExpire != null ? tokenExpire.hashCode() : 0);
        return result;
    }

    public Collection<Restaurant> getRestaurantsByToken() {
        return restaurantsByToken;
    }

    public void setRestaurantsByToken(Collection<Restaurant> restaurantsByToken) {
        this.restaurantsByToken = restaurantsByToken;
    }

    @Override
    public Token clone() {
        try {
            Token clone = (Token) super.clone();

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
