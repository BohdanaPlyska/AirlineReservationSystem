package com.example.demo.repository;

import com.example.demo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    @Query("SELECT o FROM Payment o where o.user.id = ?1 and o.ticket.id = ?2")
    Optional<Payment> findByUserAndTicket(Long user, Long ticket);
}
