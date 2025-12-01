package org.example.intern_intelligence_portfolioapi.controller;

import lombok.RequiredArgsConstructor;
import org.example.intern_intelligence_portfolioapi.entity.User;
import org.example.intern_intelligence_portfolioapi.service.impl.AuthServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthServiceImpl authServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {

        String result = authServiceImpl.register(user);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        System.out.println("Login attempt for username: " + user.getUsername());

        try {
            String token = authServiceImpl.login(user.getUsername(), user.getPassword());
            System.out.println("Token generated :" + token);
            return ResponseEntity.ok(token);
        } catch (Exception e) {
            System.err.println("Login error :" + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(403).body("Login failed :" + e.getMessage());
        }

    }
}
