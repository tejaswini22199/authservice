package com.authservice.controller;

import org.springframework.web.bind.annotation.*;
import com.authservice.model.User;
import com.authservice.service.AuthService;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        return ResponseEntity.ok(authService.register(user));
    }

    @PostMapping("/login") // 🔥 New Login API
    public ResponseEntity<String> login(@RequestBody User user) {
        boolean isValid = authService.validateUser(user.getEmail(), user.getPassword());
        if (isValid) {
            return ResponseEntity.ok("Login successful! 🔥");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials! ❌");
        }
    }
}
