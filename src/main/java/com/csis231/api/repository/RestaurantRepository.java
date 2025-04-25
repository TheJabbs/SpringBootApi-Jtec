package com.csis231.api.repository;

import com.csis231.api.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Query("SELECT r FROM Restaurant r WHERE r.tokenByRestaurantToken.token = :token AND (r.tokenByRestaurantToken.tokenExpire IS NULL OR r.tokenByRestaurantToken.tokenExpire > CURRENT_TIMESTAMP)")
    Restaurant findRestaurantByTokenAndTokenNotExpired(String token);

}