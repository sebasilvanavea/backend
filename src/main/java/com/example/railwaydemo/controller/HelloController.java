package com.example.railwaydemo.controller;

import com.example.railwaydemo.model.DemoEntity;
import com.example.railwaydemo.repository.DemoEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HelloController {
    @Autowired
    private DemoEntityRepository demoEntityRepository;

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
        return ResponseEntity.ok(response);
    }

    @GetMapping("/demo")
    public List<DemoEntity> getAllDemoEntities() {
        return demoEntityRepository.findAll();
    }

    @PostMapping("/demo")
    public DemoEntity createDemoEntity(@RequestBody DemoEntity demoEntity) {
        return demoEntityRepository.save(demoEntity);
    }
} 