package com.example.demo.repository;

import com.example.demo.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

    @Query("SELECT o FROM PaymentEntity o where o.user.id = :user and o.ticket.id = :ticket")
    Optional<PaymentEntity> findByUserAndTicket(
            @Param("user") Long user,
            @Param("ticket") Long ticket
    );

    @Query("SELECT o FROM PaymentEntity o where o.ticket.id = :ticket")
    Optional<PaymentEntity> findByTicketId(@Param("ticket") Long ticket);

}
