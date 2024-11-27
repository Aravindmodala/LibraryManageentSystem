package com.example.demo.Contoller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Users;
import com.example.demo.Service.Userservice;

@RestController

public class Usercontroller {
	
	@Autowired
	private Userservice userservice;
	
	@GetMapping("/api/users")
	public List<Users> getAllUsers() {
		return userservice.getAllUsers();
	}
	 @GetMapping("/login")
	    public String loginPage() {
	        return "login"; // Return the name of your HTML login file
	    }
	@PostMapping("/login")
	    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
	        boolean isValidUser = userservice.validateUser(email, password);
	        if (isValidUser) {
	            return ResponseEntity.ok("Login successful!");
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
	        }
	    }
	
	
}
