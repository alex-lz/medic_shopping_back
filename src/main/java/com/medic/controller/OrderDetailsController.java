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
import org.springframework.web.bind.annotation.RestController;

import com.medic.exception.ResourceNotFoundException;
import com.medic.model.OrderDetails;
import com.medic.model.OrderDetailsID;
import com.medic.repository.OrderDetailsRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class OrderDetailsController {
	
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    
    @GetMapping("/orderDetails/all")
    public List<OrderDetails> getAllOrderDetailss() {
        return orderDetailsRepository.findAll();
    }

    @GetMapping("/orderDetails/{order}/{prod}")
    public ResponseEntity<OrderDetails> getOrderDetailsById(
    	 @PathVariable(value = "order") long orderID,
       	 @PathVariable(value = "prod") long productID)
        throws ResourceNotFoundException {
    	OrderDetailsID orderDetailsId = new  OrderDetailsID();
    	orderDetailsId.setOrderID(orderID);
    	orderDetailsId.setProductID(productID);
    	
        OrderDetails orderDetails = orderDetailsRepository.findById(orderDetailsId)		
          .orElseThrow(() -> new ResourceNotFoundException("OrderDetails not found for this id :: " + orderDetailsId));
        return ResponseEntity.ok().body(orderDetails);
    }
    
    @PostMapping("/register/orderDetails")
    public OrderDetails createOrderDetails(@Valid @RequestBody OrderDetails orderDetails) {
    	
        return orderDetailsRepository.save(orderDetails);
    }

    @PutMapping("/update/orderDetails/{order}/{prod}")
    public ResponseEntity<OrderDetails> updateOrderDetails(
    		 @PathVariable(value = "order") long orderID,
           	 @PathVariable(value = "prod") long productID,
         @Valid @RequestBody OrderDetails orderDetailsDetails) throws ResourceNotFoundException {
    	OrderDetailsID orderDetailsId = new  OrderDetailsID();
    	orderDetailsId.setOrderID(orderID);
    	orderDetailsId.setProductID(productID);
    	
        OrderDetails orderDetails = orderDetailsRepository.findById(orderDetailsId)
        .orElseThrow(() -> new ResourceNotFoundException("OrderDetails not found for this id :: " + orderDetailsId));

        orderDetails.setOrderDetailsID(orderDetailsDetails.getOrderDetailsID());
        orderDetails.setQuantity(orderDetailsDetails.getQuantity());
        orderDetails.setPharmacyID(orderDetailsDetails.getPharmacyID());
        orderDetails.setOrderStatus(orderDetailsDetails.isOrderStatus());
        
        final OrderDetails updatedOrderDetails = orderDetailsRepository.save(orderDetails);
        return ResponseEntity.ok(updatedOrderDetails);
    }

    @DeleteMapping("/delete/orderDetails/{order}/{prod}")
    public Map<String, Boolean> deleteOrderDetails(
    	@PathVariable(value = "order") long orderID,
        @PathVariable(value = "prod") long productID)
         throws ResourceNotFoundException {
    	OrderDetailsID orderDetailsId = new  OrderDetailsID();
    	orderDetailsId.setOrderID(orderID);
    	orderDetailsId.setProductID(productID);
    	
        OrderDetails orderDetails = orderDetailsRepository.findById(orderDetailsId)
       .orElseThrow(() -> new ResourceNotFoundException("OrderDetails not found for this id :: " + orderDetailsId));

        orderDetailsRepository.delete(orderDetails);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
