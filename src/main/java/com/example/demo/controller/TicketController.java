package com.example.demo.controller;

import com.example.demo.entity.TicketEntity;
import com.example.demo.request.TicketRequest;
import com.example.demo.response.TicketResponse;
import com.example.demo.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.demo.constants.UrlPagesConstants.*;

@RestController
@RequestMapping(TICKETS_PAGE_URL)
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping("/createReservationForTicket/{id}")
    public TicketResponse createReservationForTicket(@PathVariable("id") Long id) {
        return  ticketService.createReservationForTicket(id);
    }

    @PostMapping
    public TicketResponse save(@RequestBody @Valid TicketRequest ticket) {
        return ticketService.save(ticket);
    }

    @DeleteMapping(ID_PAGE_URL)
    public Boolean deleteTicket(@PathVariable Long id) {
        ticketService.delete(id);
        return ticketService.getTicket(id).isEmpty();
    }

    @GetMapping
    public List<TicketResponse> showAllTickets() {
        return ticketService.allTickets();
     }

     @GetMapping(ID_PAGE_URL)
    public TicketResponse getTicket(@PathVariable Long id) {
        return ticketService.findById(id);
     }


}
