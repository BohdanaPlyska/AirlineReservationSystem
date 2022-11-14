package com.example.demo.repository;

import com.example.demo.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FlightRepository extends JpaRepository<FlightEntity,Long> {

    Optional<FlightEntity> findByFlightNumber(String flightNumber);
}
