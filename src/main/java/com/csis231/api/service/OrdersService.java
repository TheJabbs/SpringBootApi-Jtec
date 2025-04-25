package com.csis231.api.service;

import com.csis231.api.exception.ResourceNotFoundException;
import com.csis231.api.model.Orders;
import com.csis231.api.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrdersService {

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> getAllOrderss() {
        return ordersRepository.findAll();
    }

    public Orders getOrdersById(Long id) {
        return ordersRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Orders not found"));
    }

    public Orders createOrders(Orders orders) {
        return ordersRepository.save(orders);
    }

    public Orders updateOrders(Long id, Orders ordersDetails) {
        Orders orders = ordersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Orders not found with id : " + id));

        orders = ordersDetails.clone();

        return ordersRepository.save(orders);
    }

    public Map<String, Boolean> deleteOrders(Long id) {
        Optional<Orders> optionalOrders = ordersRepository.findById(id);
        if (optionalOrders.isEmpty()) {
            throw new ResourceNotFoundException("Orders not found with id : " + id);
        }

        ordersRepository.deleteById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}