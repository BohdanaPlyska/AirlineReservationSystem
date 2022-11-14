package com.example.demo.repository;

import com.example.demo.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TicketRepository extends JpaRepository<TicketEntity,Long> {

    Optional<TicketEntity> findBySeatNumber(Long seatNumber);

}
