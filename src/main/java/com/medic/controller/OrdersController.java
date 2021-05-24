package com.medic.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medic.exception.ResourceNotFoundException;
import com.medic.model.Orders;
import com.medic.repository.OrdersRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
//@RequestMapping("/api/v1")
public class OrdersController {
	
    @Autowired
    private OrdersRepository ordersRepository;

    @GetMapping("/orders/all")
    public List<Orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    @GetMapping("/orders/{id}")
    public ResponseEntity<Orders> getOrdersById(@PathVariable(value = "id") Long ordersId)
        throws ResourceNotFoundException {
        Orders orders = ordersRepository.findById(ordersId)
          .orElseThrow(() -> new ResourceNotFoundException("Orders not found for this id :: " + ordersId));
        return ResponseEntity.ok().body(orders);
    }
    
    @PostMapping("/register/orders")
    public Orders createOrders(@Valid @RequestBody Orders orders) {
        return ordersRepository.save(orders);
    }

    @PutMapping("/update/orders/{id}")
    public ResponseEntity<Orders> updateOrders(@PathVariable(value = "id") Long ordersId,
         @Valid @RequestBody Orders ordersDetails) throws ResourceNotFoundException {
        Orders orders = ordersRepository.findById(ordersId)
        .orElseThrow(() -> new ResourceNotFoundException("Orders not found for this id :: " + ordersId));

        orders.setOrderID(ordersDetails.getOrderID());
        orders.setUserEmail(ordersDetails.getUserEmail());
        orders.setDeliverUser(ordersDetails.getDeliverUser());
        orders.setShippingAddress(ordersDetails.getShippingAddress());
        orders.setOrderDate(ordersDetails.getOrderDate());
        orders.setAmount(ordersDetails.getAmount());
        orders.setOrderStatus(ordersDetails.getOrderStatus());
      
        final Orders updatedOrders = ordersRepository.save(orders);
        return ResponseEntity.ok(updatedOrders);
    }

    @DeleteMapping("/delete/orders/{id}")
    public Map<String, Boolean> deleteOrders(@PathVariable(value = "id") Long ordersId)
         throws ResourceNotFoundException {
        Orders orders = ordersRepository.findById(ordersId)
       .orElseThrow(() -> new ResourceNotFoundException("Orders not found for this id :: " + ordersId));

        ordersRepository.delete(orders);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
