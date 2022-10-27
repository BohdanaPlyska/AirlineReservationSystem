package com.example.demo.mapper;

import com.example.demo.entity.TicketEntity;
import com.example.demo.request.TicketRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketEntity ticketRequestToTicket(TicketRequest ticketRequest);

}
