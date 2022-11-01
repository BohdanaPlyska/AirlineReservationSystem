package com.example.demo.mapper;

import com.example.demo.entity.Reservation;
import com.example.demo.entity.Ticket;
import com.example.demo.request.ReservationRequest;
import com.example.demo.request.ReservationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(source = "ticket", target = "ticket")
    Reservation reservationRequestToReservationEntity(ReservationRequest request, Ticket ticket);

//    @Mapping(source = "ticket", target = "ticket.id")
    ReservationResponse reservationEntityToReservationResponse(Reservation reservation);

}
