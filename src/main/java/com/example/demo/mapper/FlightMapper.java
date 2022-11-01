package com.example.demo.mapper;

import com.example.demo.entity.Flight;
import com.example.demo.request.FlightRequest;
import com.example.demo.request.FlightResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper {

     Flight flightRequestToFlightEntity(FlightRequest flightRequest);

     FlightResponse flightEntityToFlightResponse(Flight flightEntity);

     List<FlightResponse> flightEntityListToFlightResponse(List<Flight> flightEntity);

}
