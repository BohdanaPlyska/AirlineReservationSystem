package com.example.demo.mapper;

import com.example.demo.entity.ReservationEntity;
import com.example.demo.entity.TicketEntity;
import com.example.demo.request.ReservationRequest;
import com.example.demo.response.ReservationResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    @Mapping(source = "ticket", target = "ticket")
    ReservationEntity reservationRequestToReservationEntity(ReservationRequest request, TicketEntity ticket);

    ReservationResponse reservationEntityToReservationResponse(ReservationEntity reservationEntity);

}
