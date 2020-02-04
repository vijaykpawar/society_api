package com.society.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.society.api.exception.ResourceNotFoundException;
import com.society.api.model.User;
import com.society.api.repository.UserReporsitory;

/**
 * Created by Nitin Dubal
 */
@RestController
@RequestMapping("/api")
public class UserController{

    @Autowired
    UserReporsitory userReporsitory;

    @GetMapping("/Users")
    public List<User> getAllUsers() {
        return userReporsitory.findAll();
    }

    @PostMapping("/Users")
    public User createUser(@Valid @RequestBody User user) {
        return userReporsitory.save(user);
    }

    @GetMapping("/Users/{id}")
    public User getUserById(@PathVariable(value = "id") Long userCode) {
        return userReporsitory.findById(userCode)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userCode));
    }

    @PutMapping("/Users/{id}")
    public User updateUser(@PathVariable(value = "id") Long userCode,
                                           @Valid @RequestBody User userDetails) {

        User user = userReporsitory.findById(userCode)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userCode));

       user.setUserName(user.getUserName());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setEmailId(user.getEmailId());
        

        User updatedUser = userReporsitory.save(user);
        return updatedUser;
    }

    @DeleteMapping("/Users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long userCode) {
        User user = userReporsitory.findById(userCode)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userCode));
        userReporsitory.delete(user);
    
        return ResponseEntity.ok().build();
    }
}
