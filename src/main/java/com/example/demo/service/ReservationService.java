package com.example.demo.service;

import com.example.demo.entity.Reservation;
import com.example.demo.entity.Ticket;
import com.example.demo.exception.CustomAlreadyExistException;
import com.example.demo.exception.CustomFoundException;
import com.example.demo.mapper.ReservationMapper;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.request.ReservationRequest;
import com.example.demo.request.ReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    private final ReservationMapper reservationMapper;

    private final TicketRepository ticketRepository;

    //Not ready need logic how to check if reservation already exist and need to add Flight and type of plane then check reservation
    public ReservationResponse save(ReservationRequest request) {

        Optional<Reservation> reservation = reservationRepository.findByTicketId(request.getTicket());
        if(reservation.isPresent()) {
            throw new CustomAlreadyExistException("Reservation already exist");
        }

        Optional<Ticket> ticket = ticketRepository.findById(request.getTicket());
        if(ticket.isEmpty()) {
            throw new CustomFoundException("Ticket not found");
        }

        Reservation validDataForReservation = reservationMapper.reservationRequestToReservationEntity(request, ticket.get());
        Reservation reservation1= reservationRepository.save(validDataForReservation);
        return reservationMapper.reservationEntityToReservationResponse(reservation1);

    }

}
