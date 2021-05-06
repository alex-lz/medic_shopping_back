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
import com.medic.model.Shoppingcart;
import com.medic.model.ShoppingcartID;
import com.medic.repository.ShoppingcartRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ShoppingcartController {
	
    @Autowired
    private ShoppingcartRepository shoppingcartRepository;
    
    @GetMapping("/shoppingcart/all")
    public List<Shoppingcart> getAllShoppingcarts() {
        return shoppingcartRepository.findAll();
    }

    @GetMapping("/shoppingcart/{email}/{prod}")
    public ResponseEntity<Shoppingcart> getShoppingcartById(
    	 @PathVariable(value = "email") String userEmail,
       	 @PathVariable(value = "prod") long productID)
        throws ResourceNotFoundException {
    	ShoppingcartID shoppingcartId = new  ShoppingcartID();
    	shoppingcartId.setUserEmail(userEmail);
    	shoppingcartId.setProductID(productID);
    	
        Shoppingcart shoppingcart = shoppingcartRepository.findById(shoppingcartId)		
          .orElseThrow(() -> new ResourceNotFoundException("Shoppingcart not found for this id :: " + shoppingcartId));
        return ResponseEntity.ok().body(shoppingcart);
    }
    
    @PostMapping("/register/shoppingcart")
    public Shoppingcart createShoppingcart(@Valid @RequestBody Shoppingcart shoppingcart) {
    	
        return shoppingcartRepository.save(shoppingcart);
    }

    @PutMapping("/update/shoppingcart/{email}/{prod}")
    public ResponseEntity<Shoppingcart> updateShoppingcart(
    		 @PathVariable(value = "email") String userEmail,
           	 @PathVariable(value = "prod") long productID,
         @Valid @RequestBody Shoppingcart shoppingcartDetails) throws ResourceNotFoundException {
    	ShoppingcartID shoppingcartId = new  ShoppingcartID();
    	shoppingcartId.setUserEmail(userEmail);
    	shoppingcartId.setProductID(productID);
    	
        Shoppingcart shoppingcart = shoppingcartRepository.findById(shoppingcartId)
        .orElseThrow(() -> new ResourceNotFoundException("Shoppingcart not found for this id :: " + shoppingcartId));

        shoppingcart.setShoppingcartID(shoppingcartDetails.getShoppingcartID());
        shoppingcart.setQuantity(shoppingcartDetails.getQuantity());
        shoppingcart.setShoppingcartStatus(shoppingcartDetails.isShoppingcartStatus());
        
        final Shoppingcart updatedShoppingcart = shoppingcartRepository.save(shoppingcart);
        return ResponseEntity.ok(updatedShoppingcart);
    }

    @DeleteMapping("/delete/shoppingcart/{email}/{prod}")
    public Map<String, Boolean> deleteShoppingcart(
    	@PathVariable(value = "email") String userEmail,
        @PathVariable(value = "prod") long productID)
         throws ResourceNotFoundException {
    	ShoppingcartID shoppingcartId = new  ShoppingcartID();
    	shoppingcartId.setUserEmail(userEmail);
    	shoppingcartId.setProductID(productID);
    	
        Shoppingcart shoppingcart = shoppingcartRepository.findById(shoppingcartId)
       .orElseThrow(() -> new ResourceNotFoundException("Shoppingcart not found for this id :: " + shoppingcartId));

        shoppingcartRepository.delete(shoppingcart);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
