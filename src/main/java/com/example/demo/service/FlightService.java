package com.example.demo.service;

import com.example.demo.entity.Flight;
import com.example.demo.exception.CustomAlreadyExistException;
import com.example.demo.exception.CustomFoundException;
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

    public FlightResponse save(FlightRequest flightRequest) {
        Optional<Flight> flightSearch = flightRepository.findByFlightNumber(flightRequest.getFlightNumber());
       if(!flightSearch.isEmpty()){
           throw new CustomAlreadyExistException("Flight already exist");
       }

        Flight validDataForFlight = flightMapper.flightRequestToFlightEntity(flightRequest);
        Flight flight = flightRepository.save(validDataForFlight);
        return flightMapper.flightEntityToFlightResponse(flight);
    }

    public void delete(Long id) {
        Optional<Flight> flightEntityOptional = flightRepository.findById(id);
        flightEntityOptional.ifPresent(flightRepository::delete);
    }

    public List<FlightResponse> allFlights() {
         List<Flight> flightEntities = flightRepository.findAll();
         return flightMapper.flightEntityListToFlightResponse(flightEntities);
    }

    public FlightResponse findById(Long id) {
        Optional<Flight> flight = flightRepository.findById(id);
        if(flight.isEmpty()){
            throw new CustomFoundException("Flight not found");
        }
        return flightMapper.flightEntityToFlightResponse(flightRepository.findById(id).get());
    }

    public Optional<Flight> getFlight(Long id) {
        return flightRepository.findById(id);
    }

}
