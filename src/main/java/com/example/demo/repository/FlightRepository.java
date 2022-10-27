package com.example.demo.repository;

import com.example.demo.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightEntity,Long> {
}
