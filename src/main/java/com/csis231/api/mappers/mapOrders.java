package com.csis231.api.mappers;

import com.csis231.api.DTO.OrderDto;
import com.csis231.api.controller.FoodController;
import com.csis231.api.model.Orders;
import com.csis231.api.repository.FoodRepository;
import com.csis231.api.repository.OrdersRepository;

public class mapOrders {
    public static Orders toOrders(OrderDto orderDto) {
        Orders orders = new Orders();
        orders.setOrderId(orderDto.getId());
        orders.setRestaurantId(1);
        orders.setEmployeeId(1);


        return orders;
    }
}
