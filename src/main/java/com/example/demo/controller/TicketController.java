package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.TicketRequest;
import com.example.demo.response.TicketResponse;
import com.example.demo.response.UserResponse;
import com.example.demo.service.TicketService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.demo.constants.UrlPagesConstants.*;

@RestController
@RequestMapping(TICKETS_PAGE_URL)
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    private final UserService userService;

    @PostMapping("/createReservationForTicket/{id}")
    public TicketResponse createReservationForTicket(@PathVariable("id") Long id, Authentication authentication) {
        UserResponse user = userService.findByEmail(authentication.getName());
        return  ticketService.createReservationForTicket(id, user.getEmail());
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
