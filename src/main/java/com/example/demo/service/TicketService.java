package com.example.demo.service;

import com.example.demo.entity.FlightEntity;
import com.example.demo.entity.TicketEntity;
import com.example.demo.exception.CustomFoundException;
import com.example.demo.mapper.TicketMapper;
import com.example.demo.repository.FlightRepository;
import com.example.demo.repository.TicketRepository;
import com.example.demo.request.TicketRequest;
import com.example.demo.response.TicketResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.demo.constants.ValidationMessages.*;

@Service
@RequiredArgsConstructor
public class TicketService{

    private final TicketRepository ticketRepository;

    private final TicketMapper ticketMapper;

    private final FlightRepository flightRepository;

//    public TicketEntity addTicketToBasket(TicketEntity ticket) {
//        return null;
//    }
//
//    public TicketEntity buyTicket(TicketRequest ticketRequest) {
//        //when user choose the ticket, fill info and choose discount =>
//        // then we need to look on all active user tickets and update reservation time for all of them
//        // request to db create reservation for ticket => we set reservation id to reservation table
//        //calculate price which will be final including the discount
//        //=> create payment and set all fields status, ticketId, finalPrice...
//        //update ticket  status like sold/not available
//        return null;
//    }
//
//    public List<TicketEntity> availableTickets() {
//        //if in reservation id != null && experation time > (current time +...algorithm)
//        // and in ticket have payment id not null it means sold ticket
//        return null;
//    }

    public TicketResponse save(TicketRequest ticket) {
        findTicketByFlightNumber(ticket);
        findTicketBySeatNumber(ticket);
        TicketEntity validDataForTicket = ticketMapper.ticketRequestToTicketEntity(ticket);
        TicketEntity ticketEntity = ticketRepository.save(validDataForTicket);
        return ticketMapper.ticketEntityToTicketResponse(ticketEntity);
    }

    public void delete(Long id) {
        Optional<TicketEntity> ticket = ticketRepository.findById(id);
        ticket.ifPresent(ticketRepository::delete);
    }

    public List<TicketResponse> allTickets() {
        return ticketMapper.listTicketEntityToListTicketResponse(ticketRepository.findAll());
    }

    public TicketResponse findById(Long id) {
        return ticketMapper.ticketEntityToTicketResponse(Optional
                .ofNullable(
                        ticketRepository
                                .findById(id)
                                .orElseThrow(() -> new CustomFoundException(TICKET_NOT_FOUND))
                )
                .get()
        );
    }

    public Optional<TicketEntity> getTicket(Long id) {
        return ticketRepository.findById(id);
    }

    public Optional<FlightEntity> findTicketByFlightNumber(TicketRequest ticket){
        return Optional
                .ofNullable(
                        flightRepository
                                .findByFlightNumber(ticket.getFlightNumber())
                                .orElseThrow(() -> new CustomFoundException(FLIGHT_NOT_FOUND))
                );
    }

    public Optional<TicketEntity> findTicketBySeatNumber(TicketRequest ticket){
         return Optional
                .ofNullable(
                        ticketRepository
                            .findBySeatNumber(ticket.getSeatNumber())
                            .orElseThrow(() ->  new CustomFoundException(TICKET_ALREADY_EXIST))
                );
    }

}
