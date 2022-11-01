package com.example.demo.controller;

import com.example.demo.entity.Ticket;
import com.example.demo.request.TicketRequest;
import com.example.demo.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.demo.constants.DefaultAppConstants.*;

@RestController
@RequestMapping(TICKETS_PAGE_URL)
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public Ticket save(@RequestBody @Valid TicketRequest ticket) {
        return ticketService.save(ticket);
    }

    @DeleteMapping(ID_PAGE_URL)
    public Boolean deleteTicket(@PathVariable Long id) {
        ticketService.delete(id);
        return ticketService.getTicket(id).isEmpty();
    }

    @GetMapping
    public List<Ticket> showAllTickets() {
        return ticketService.allTickets();
     }

     @GetMapping(ID_PAGE_URL)
    public Ticket getTicket(@PathVariable Long id) {
        return ticketService.findById(id);
     }


}
