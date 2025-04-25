package com.csis231.api.controller;

import com.csis231.api.DTO.OrderDto;
import com.csis231.api.model.Orderlist;
import com.csis231.api.model.Orders;
import com.csis231.api.service.OrdersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/orderss")
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;

    }

    @GetMapping
    public List<Orders> getAllOrderss() {
        return ordersService.getAllOrderss();
    }

    @PostMapping
    public ResponseEntity<Orders> createOrders(@Valid @RequestBody Orders orders) {
        Orders savedOrders = ordersService.createOrders(orders);
        return new ResponseEntity<Orders>(savedOrders, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrdersById(@PathVariable Long id) {
        return ResponseEntity.ok(ordersService.getOrdersById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateOrders(@PathVariable Long id, @Valid @RequestBody Orders ordersDetails, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid orders data");
        }
        Orders updatedOrders = ordersService.updateOrders(id, ordersDetails);
        return ResponseEntity.ok(updatedOrders);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrders(@PathVariable Long id) {
        ordersService.deleteOrders(id);
        return ResponseEntity.noContent().build();
    }
}