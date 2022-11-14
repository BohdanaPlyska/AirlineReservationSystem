package com.example.demo.service;

import com.example.demo.entity.ReservationEntity;
import com.example.demo.entity.TicketEntity;
import com.example.demo.exception.CustomAlreadyExistException;
import com.example.demo.exception.CustomFoundException;
import com.example.demo.mapper.ReservationMapper;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.request.ReservationRequest;
import com.example.demo.response.ReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.demo.constants.ValidationMessages.RESERVATION_ALREADY_EXIST;
import static com.example.demo.constants.ValidationMessages.TICKET_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    private final ReservationMapper reservationMapper;

    private final TicketRepository ticketRepository;

    public ReservationResponse save(ReservationRequest request) {
        findReservationByTicketId(request);
        Optional<TicketEntity> ticket = findTicketById(request);
        ReservationEntity validDataForReservationEntity = reservationMapper.reservationRequestToReservationEntity(request, ticket.get());
        ReservationEntity reservationEntity1 = reservationRepository.save(validDataForReservationEntity);
        return reservationMapper.reservationEntityToReservationResponse(reservationEntity1);

    }

    public  Optional<ReservationEntity> findReservationByTicketId(ReservationRequest request){
        Optional<ReservationEntity> reservation = reservationRepository.findByTicketId(request.getTicket());
        if(reservation.isPresent()) {
            throw new CustomAlreadyExistException(RESERVATION_ALREADY_EXIST);
        }
        return reservation;
    }

    public  Optional<TicketEntity> findTicketById(ReservationRequest request){
        Optional<TicketEntity> ticket = ticketRepository.findById(request.getTicket());
        if(ticket.isEmpty()) {
            throw new CustomFoundException(TICKET_NOT_FOUND);
        }
        return ticket;
    }


}
