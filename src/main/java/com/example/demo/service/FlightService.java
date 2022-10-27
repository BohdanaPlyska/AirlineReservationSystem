package com.example.demo.service;

import com.example.demo.entity.FlightEntity;
import com.example.demo.mapper.FlightMapper;
import com.example.demo.repository.FlightRepository;
import com.example.demo.request.FlightRequest;
import com.example.demo.request.FlightResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    private final FlightMapper flightMapper;

    public FlightResponse saveAndUpdate(FlightRequest flightRequest) {
        FlightEntity validDataForFlight = flightMapper.flightRequestToFlightEntity(flightRequest);
        FlightEntity flightEntity = flightRepository.save(validDataForFlight);
        return flightMapper.flightEntityToFlightResponse(flightEntity);
    }

    public void delete(Long id) {
        Optional<FlightEntity> flightEntityOptional = flightRepository.findById(id);
        flightEntityOptional.ifPresent(flightRepository::delete);
    }

    public List<FlightResponse> allFlights() {
         List<FlightEntity> flightEntities = flightRepository.findAll();
         return flightMapper.flightEntityListToFlightResponse(flightEntities);
    }

    public FlightResponse findById(Long id) {
        return flightMapper.flightEntityToFlightResponse(flightRepository.findById(id).get());
    }

    public Optional<FlightEntity> getFlight(Long id) {
        return flightRepository.findById(id);
    }

}
