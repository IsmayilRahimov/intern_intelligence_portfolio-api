package org.example.intern_intelligence_portfolioapi.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.example.intern_intelligence_portfolioapi.dto.PortfolioCreateDto;
import org.example.intern_intelligence_portfolioapi.dto.PortfolioUpdateDto;

import org.example.intern_intelligence_portfolioapi.security.JwtUtill;
import org.example.intern_intelligence_portfolioapi.service.impl.PortfolioServiceImpl;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolio")
@RequiredArgsConstructor

public class PortfolioController {
    private final PortfolioServiceImpl portfolioServiceImpl;
    private final JwtUtill jwtUtil;

    private Long getUserIdFromRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            return jwtUtil.getUserId(token);
        }
        throw new RuntimeException("Token tapılmadı");
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPortfolio(@RequestBody PortfolioCreateDto dto, HttpServletRequest request) {
        Long userId = getUserIdFromRequest(request);
        return ResponseEntity.ok(portfolioServiceImpl.create(dto, userId));
    }

    @PutMapping("/update/{id}")

    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PortfolioUpdateDto dto, HttpServletRequest request) {
        Long userId = getUserIdFromRequest(request);
        return ResponseEntity.ok(portfolioServiceImpl.update(id, dto, userId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(portfolioServiceImpl.getByUserId(userId));
    }

    @GetMapping("byId/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(portfolioServiceImpl.getPortfolio(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePortfolio(@PathVariable Long id, HttpServletRequest request) {
        Long userId = getUserIdFromRequest(request);
        String message = portfolioServiceImpl.delete(id, userId);

        return ResponseEntity.ok(message);

    }


}
