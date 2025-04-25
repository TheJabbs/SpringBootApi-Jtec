package com.csis231.api.service;

import com.csis231.api.exception.ResourceNotFoundException;
import com.csis231.api.model.Orderlist;
import com.csis231.api.repository.OrderlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderlistService {

    private final OrderlistRepository orderlistRepository;

    @Autowired
    public OrderlistService(OrderlistRepository orderlistRepository) {
        this.orderlistRepository = orderlistRepository;
    }

    public List<Orderlist> getAllOrderlists() {
        return orderlistRepository.findAll();
    }

    public Orderlist getOrderlistById(Long id) {
        return orderlistRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Orderlist not found"));
    }

    public Orderlist createOrderlist(Orderlist orderlist) {
        return orderlistRepository.save(orderlist);
    }

    public Orderlist updateOrderlist(Long id, Orderlist orderlistDetails) {
        Orderlist orderlist = orderlistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Orderlist not found with id : " + id));

        orderlist = orderlistDetails.clone();

        return orderlistRepository.save(orderlist);
    }

    public Map<String, Boolean> deleteOrderlist(Long id) {
        Optional<Orderlist> optionalOrderlist = orderlistRepository.findById(id);
        if (optionalOrderlist.isEmpty()) {
            throw new ResourceNotFoundException("Orderlist not found with id : " + id);
        }

        orderlistRepository.deleteById(id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    public List<Orderlist> createOrderlists(List<Orderlist> orderlists) {
        return orderlistRepository.saveAll(orderlists);
    }
}