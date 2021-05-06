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
import com.medic.model.User;
import com.medic.repository.UserRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
//@RequestMapping("/api/v1")
public class UserController {
	
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/all")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") String userEmail)
        throws ResourceNotFoundException {
        User user = userRepository.findById(userEmail)
          .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userEmail));
        return ResponseEntity.ok().body(user);
    }
    
    @PostMapping("/register/user")
    public User createUser(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/update/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") String userEmail,
         @Valid @RequestBody User userDetails) throws ResourceNotFoundException {
        User user = userRepository.findById(userEmail)
        .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userEmail));

        user.setUserAddress(userDetails.getUserAddress());
        user.setUserPassword(userDetails.getUserPassword());
        user.setUserFCMToken(userDetails.getUserFCMToken());
        user.setUserName(userDetails.getUserName());
        user.setUserLast(userDetails.getUserLast());
        user.setUserCellphone(userDetails.getUserCellphone());
        user.setUserURLPicture(userDetails.getUserURLPicture());
        user.setUserType(userDetails.getUserType());
        user.setUserPharmacy(userDetails.getUserPharmacy());

        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/delete/user/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") String userEmail)
         throws ResourceNotFoundException {
        User user = userRepository.findById(userEmail)
       .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userEmail));

        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
