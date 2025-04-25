package com.csis231.api.controller;

import com.csis231.api.model.Orderlist;
import com.csis231.api.model.Orders;
import com.csis231.api.service.OrderlistService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/orderlists")
public class OrderlistController {

    private final OrderlistService orderlistService;

    public OrderlistController(OrderlistService orderlistService) {
        this.orderlistService = orderlistService;
    }

    @GetMapping
    public List<Orderlist> getAllOrderlists() {
        return orderlistService.getAllOrderlists();
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Orderlist>> createOrderlists(@Valid @RequestBody List<Orders> ordersList) {
        List<Orderlist> savedOrderlists = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        ordersList.forEach(order -> {
            try {
                String json = mapper.writeValueAsString(order);
                Orderlist orderlist = new Orderlist();
                orderlist.setFood(json);
                savedOrderlists.add(orderlistService.createOrderlist(orderlist));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });

        return new ResponseEntity<>(savedOrderlists, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<Orderlist> createOrderlist(@Valid @RequestBody Orderlist orderlist) {
        Orderlist savedOrderlist = orderlistService.createOrderlist(orderlist);
        return new ResponseEntity<Orderlist>(savedOrderlist, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orderlist> getOrderlistById(@PathVariable Long id) {
        return ResponseEntity.ok(orderlistService.getOrderlistById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateOrderlist(@PathVariable Long id, @Valid @RequestBody Orderlist orderlistDetails, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Invalid orderlist data");
        }
        Orderlist updatedOrderlist = orderlistService.updateOrderlist(id, orderlistDetails);
        return ResponseEntity.ok(updatedOrderlist);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderlist(@PathVariable Long id) {
        orderlistService.deleteOrderlist(id);
        return ResponseEntity.noContent().build();
    }
}