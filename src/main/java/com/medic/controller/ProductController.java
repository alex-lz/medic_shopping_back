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
import com.medic.model.Product;
import com.medic.repository.ProductRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
//@RequestMapping("/api/v1")
public class ProductController {
	
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product/all")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Long productId)
        throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
          .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        return ResponseEntity.ok().body(product);
    }
    
    @PostMapping("/register/product")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("/update/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Long productId,
         @Valid @RequestBody Product productDetails) throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
        .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        product.setCategoryID(productDetails.getCategoryID());
        product.setProductName(productDetails.getProductName());
        product.setProductPower(productDetails.getProductPower());
        product.setActiveSubstance(productDetails.getActiveSubstance());
        product.setBrand(productDetails.getBrand());
        product.setProductDescription(productDetails.getProductDescription());
        product.setUnitPrice(productDetails.getUnitPrice());
        product.setProductURLPicture(productDetails.getProductURLPicture());
        product.setSells(productDetails.getSells());
        product.setProductStatus(productDetails.isProductStatus());
        final Product updatedProduct = productRepository.save(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/delete/product/{id}")
    public Map<String, Boolean> deleteProduct(@PathVariable(value = "id") Long productId)
         throws ResourceNotFoundException {
        Product product = productRepository.findById(productId)
       .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

        productRepository.delete(product);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
