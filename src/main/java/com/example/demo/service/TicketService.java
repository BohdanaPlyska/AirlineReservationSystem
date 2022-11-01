package com.example.demo.service;

import com.example.demo.entity.Ticket;
import com.example.demo.exception.CustomFoundException;
import com.example.demo.mapper.TicketMapper;
import com.example.demo.repository.TicketRepository;
import com.example.demo.request.TicketRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketService{

    private final TicketRepository ticketRepository;

    private final TicketMapper ticketMapper;

//    public Ticket addTicketToBasket(Ticket ticket) {
//        return null;
//    }
//
//    public Ticket buyTicket(TicketRequest ticketRequest) {
//        //when user choose the ticket, fill info and choose discount =>
//        // then we need to look on all active user tickets and update reservation time for all of them
//        // request to db create reservation for ticket => we set reservation id to reservation table
//        //calculate price which will be final including the discount
//        //=> create payment and set all fields status, ticketId, finalPrice...
//        //update ticket  status like sold/not available
//        return null;
//    }
//
//    public List<Ticket> availableTickets() {
//        //if in reservation id != null && experation time > (current time +...algorithm)
//        // and in ticket have payment id not null it means sold ticket
//        return null;
//    }

    public Ticket save(TicketRequest ticket) {
        Optional<Ticket> optionalTicket = ticketRepository.findBySeatNumber(ticket.getSeatNumber());
        if(optionalTicket.isPresent()) {
            throw new CustomFoundException("Ticket already exist");
        }
        return ticketRepository.save(ticketMapper.ticketRequestToTicket(ticket));
    }

    public void delete(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        ticket.ifPresent(ticketRepository::delete);
    }

    public List<Ticket> allTickets() {
        return ticketRepository.findAll();
    }

    public Ticket findById(Long id) {
        Optional<Ticket> ticket = ticketRepository.findById(id);
        if (!ticket.isPresent()){
            throw  new CustomFoundException("Ticket not found");
        }
        return ticketRepository.findById(id).get();
    }

    public Optional<Ticket> getTicket(Long id) {
        return ticketRepository.findById(id);
    }


}
