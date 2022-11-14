package com.example.demo.mapper;

import com.example.demo.entity.TicketEntity;
import com.example.demo.request.TicketRequest;
import com.example.demo.response.TicketResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketEntity ticketRequestToTicketEntity(TicketRequest ticketRequest);

    TicketResponse ticketEntityToTicketResponse(TicketEntity ticketEntity);

    List<TicketResponse> listTicketEntityToListTicketResponse(List<TicketEntity> ticketEntities);

}
