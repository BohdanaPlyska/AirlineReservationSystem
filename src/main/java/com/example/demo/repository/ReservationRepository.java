package com.example.demo.repository;

import com.example.demo.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
    Optional<ReservationEntity> findByTicketId(Long id);
}
