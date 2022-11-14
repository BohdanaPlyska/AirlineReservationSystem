package com.example.demo.mapper;

import com.example.demo.entity.FlightEntity;
import com.example.demo.request.FlightRequest;
import com.example.demo.response.FlightResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FlightMapper {

     FlightEntity flightRequestToFlightEntity(FlightRequest flightRequest);

     FlightResponse flightEntityToFlightResponse(FlightEntity flightEntity);

     List<FlightResponse> flightEntityListToFlightResponse(List<FlightEntity> flightEntity);

}
