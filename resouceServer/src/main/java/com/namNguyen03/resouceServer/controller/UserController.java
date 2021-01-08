package com.namNguyen03.resouceServer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.namNguyen03.resouceServer.model.User;
import com.namNguyen03.resouceServer.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	
    @GetMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> listUser() {
        
    	return ResponseEntity.ok(userRepository.findAll());
    }
    
    
    @GetMapping("/profile")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> getProfile(Authentication authentication) {
    	User user = userRepository.findByUsername(authentication.getName());
    	Map<String, String> response = new HashMap<String, String>();
    	response.put("username", user.getUsername());
    	response.put("fullname", user.getFullname());
        return ResponseEntity.ok(response);
    }
}
