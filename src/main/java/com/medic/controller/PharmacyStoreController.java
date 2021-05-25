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
import com.medic.model.PharmacyStore;
import com.medic.model.PharmacyStoreID;
import com.medic.repository.PharmacyStoreRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PharmacyStoreController {
	
    @Autowired
    private PharmacyStoreRepository pharmacyStoreRepository;
    
    @GetMapping("/pharmacyStore/all")
    public List<PharmacyStore> getAllPharmacyStores() {
        return pharmacyStoreRepository.findAll();
    }

    @GetMapping("/pharmacyStore/{pharmacy}/{prod}")
    public ResponseEntity<PharmacyStore> getPharmacyStoreById(
    	 @PathVariable(value = "pharmacy") long pharmacyID,
       	 @PathVariable(value = "prod") long productID)
        throws ResourceNotFoundException {
    	PharmacyStoreID pharmacyStoreId = new  PharmacyStoreID();
    	pharmacyStoreId.setPharmacyID(pharmacyID);
    	pharmacyStoreId.setProductID(productID);
    	
        PharmacyStore pharmacyStore = pharmacyStoreRepository.findById(pharmacyStoreId)		
          .orElseThrow(() -> new ResourceNotFoundException("PharmacyStore not found for this id :: " + pharmacyStoreId));
        return ResponseEntity.ok().body(pharmacyStore);
    }
    
    @PostMapping("/register/pharmacyStore")
    public PharmacyStore createPharmacyStore(@Valid @RequestBody PharmacyStore pharmacyStore) {
    	
        return pharmacyStoreRepository.save(pharmacyStore);
    }

    @PutMapping("/update/pharmacyStore/{pharmacy}/{prod}")
    public ResponseEntity<PharmacyStore> updatePharmacyStore(
    		 @PathVariable(value = "pharmacy") long pharmacyID,
           	 @PathVariable(value = "prod") long productID,
         @Valid @RequestBody PharmacyStore pharmacyStoreDetails) throws ResourceNotFoundException {
    	PharmacyStoreID pharmacyStoreId = new  PharmacyStoreID();
    	pharmacyStoreId.setPharmacyID(pharmacyID);
    	pharmacyStoreId.setProductID(productID);
    	
        PharmacyStore pharmacyStore = pharmacyStoreRepository.findById(pharmacyStoreId)
        .orElseThrow(() -> new ResourceNotFoundException("PharmacyStore not found for this id :: " + pharmacyStoreId));

        pharmacyStore.setPharmacyStoreID(pharmacyStoreDetails.getPharmacyStoreID());
        pharmacyStore.setUnitPrice(pharmacyStoreDetails.getUnitPrice());
        pharmacyStore.setDiscount(pharmacyStoreDetails.getDiscount());
        pharmacyStore.setPharmacyStatus(pharmacyStoreDetails.isPharmacyStatus());
        
        final PharmacyStore updatedPharmacyStore = pharmacyStoreRepository.save(pharmacyStore);
        return ResponseEntity.ok(updatedPharmacyStore);
    }

    @DeleteMapping("/delete/pharmacyStore/{pharmacy}/{prod}")
    public Map<String, Boolean> deletePharmacyStore(
    	@PathVariable(value = "pharmacy") long pharmacyID,
        @PathVariable(value = "prod") long productID)
         throws ResourceNotFoundException {
    	PharmacyStoreID pharmacyStoreId = new  PharmacyStoreID();
    	pharmacyStoreId.setPharmacyID(pharmacyID);
    	pharmacyStoreId.setProductID(productID);
    	
        PharmacyStore pharmacyStore = pharmacyStoreRepository.findById(pharmacyStoreId)
       .orElseThrow(() -> new ResourceNotFoundException("PharmacyStore not found for this id :: " + pharmacyStoreId));

        pharmacyStoreRepository.delete(pharmacyStore);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
