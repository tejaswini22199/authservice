package com.authservice.service;

import com.authservice.model.User;
import com.authservice.repository.UserRepository;
import com.authservice.util.JwtUtil;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public AuthService(UserRepository userRepository, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.jwtUtil = jwtUtil;
    }

    // User Registration
    public String register(User user) {
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("User already exists!");
        }
        userRepository.save(user);
        return "User registered successfully!";
    }

    // User Login (returns JWT token)
    public String login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid credentials!");
        }
        return jwtUtil.generateToken(email); // 🔥 Generate JWT Token
    }

    // Validate User (for booking service)
    public boolean validateToken(String token) {
        return jwtUtil.validateToken(token);
    }
}
