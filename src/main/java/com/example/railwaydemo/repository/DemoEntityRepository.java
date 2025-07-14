package com.example.railwaydemo.repository;

import com.example.railwaydemo.model.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemoEntityRepository extends JpaRepository<DemoEntity, Long> {} 