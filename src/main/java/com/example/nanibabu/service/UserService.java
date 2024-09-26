package com.example.nanibabu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.nanibabu.entity.User;
import com.example.nanibabu.repo.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // Use the password encoder bean

    // Method to register a user
    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encode password
        userRepository.save(user);
    }

    // Method to check login credentials
    public boolean checkLogin(User user) {
        User registeredUser = userRepository.findByUsername(user.getUsername());
        if (registeredUser == null) {
            System.out.println("User not found: " + user.getUsername());
            return false;
        }
        boolean matches = passwordEncoder.matches(user.getPassword(), registeredUser.getPassword());
        System.out.println("Login check for " + user.getUsername() + ": " + matches);
        return matches;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
