package com.example.demo.mapper;

import com.example.demo.entity.Ticket;
import com.example.demo.request.TicketRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    Ticket ticketRequestToTicket(TicketRequest ticketRequest);

}
