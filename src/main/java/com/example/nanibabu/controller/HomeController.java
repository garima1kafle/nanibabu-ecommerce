package com.example.nanibabu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.nanibabu.entity.User;

@Controller


public class HomeController {
	
	// Home page
    @GetMapping("/home")
    public String home() {
        return "e-commerce/index";  // This returns the home page (index.html)
    }
    
    // Login page
    @GetMapping("/login")
    public String login() {
        return "e-commerce/login";  // This returns the login page (login.html)
    }

    // Register page under /register
    @GetMapping("/register")
    public String register(User user) {
        return "e-commerce/register";  // This returns the register page (register.html)
    }

}
