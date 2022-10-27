package com.example.demo.mapper;

import com.example.demo.entity.TicketEntity;
import com.example.demo.request.TicketRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketEntity ticketRequestToTicket(TicketRequest ticketRequest);
}
