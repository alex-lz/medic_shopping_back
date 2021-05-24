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
import com.medic.model.Pharmacy;
import com.medic.repository.PharmacyRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
//@RequestMapping("/api/v1")
public class PharmacyController {
	
    @Autowired
    private PharmacyRepository pharmacyRepository;

    @GetMapping("/pharmacy/all")
    public List<Pharmacy> getAllPharmacies() {
        return pharmacyRepository.findAll();
    }

    @GetMapping("/pharmacy/{id}")
    public ResponseEntity<Pharmacy> getPharmacyById(@PathVariable(value = "id") Long pharmacyId)
        throws ResourceNotFoundException {
        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId)
          .orElseThrow(() -> new ResourceNotFoundException("Pharmacy not found for this id :: " + pharmacyId));
        return ResponseEntity.ok().body(pharmacy);
    }
    
    @PostMapping("/register/pharmacy")
    public Pharmacy createPharmacy(@Valid @RequestBody Pharmacy pharmacy) {
        return pharmacyRepository.save(pharmacy);
    }

    @PutMapping("/update/pharmacy/{id}")
    public ResponseEntity<Pharmacy> updatePharmacy(@PathVariable(value = "id") Long pharmacyId,
         @Valid @RequestBody Pharmacy pharmacyDetails) throws ResourceNotFoundException {
        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId)
        .orElseThrow(() -> new ResourceNotFoundException("Pharmacy not found for this id :: " + pharmacyId));

        pharmacy.setPharmacyID(pharmacyDetails.getPharmacyID());
        pharmacy.setName(pharmacyDetails.getName());
        pharmacy.setGroup(pharmacyDetails.getGroup());
        pharmacy.setAddress(pharmacyDetails.getAddress());
        pharmacy.setContact(pharmacyDetails.getContact());
        pharmacy.setLat(pharmacyDetails.getLat());
        pharmacy.setLon(pharmacyDetails.getLon());
       
        final Pharmacy updatedPharmacy = pharmacyRepository.save(pharmacy);
        return ResponseEntity.ok(updatedPharmacy);
    }

    @DeleteMapping("/delete/pharmacy/{id}")
    public Map<String, Boolean> deletePharmacy(@PathVariable(value = "id") Long pharmacyId)
         throws ResourceNotFoundException {
        Pharmacy pharmacy = pharmacyRepository.findById(pharmacyId)
       .orElseThrow(() -> new ResourceNotFoundException("Pharmacy not found for this id :: " + pharmacyId));

        pharmacyRepository.delete(pharmacy);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
