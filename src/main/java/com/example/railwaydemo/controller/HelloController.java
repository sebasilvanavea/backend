package com.example.railwaydemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public Map<String, Object> hello() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "¡Hola desde Railway!");
        response.put("timestamp", LocalDateTime.now());
        response.put("status", "success");
        response.put("service", "Spring Boot Railway Demo");
        return response;
    }

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "UP");
        response.put("timestamp", LocalDateTime.now());
        response.put("service", "Spring Boot Railway Demo");
        response.put("env", System.getenv("RAILWAY_ENVIRONMENT_NAME"));
        return ResponseEntity.ok(response);
    }
} 