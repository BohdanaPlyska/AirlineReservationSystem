package com.example.demo.service;

import com.example.demo.entity.FlightEntity;
import com.example.demo.exception.CustomAlreadyExistException;
import com.example.demo.exception.CustomFoundException;
import com.example.demo.mapper.FlightMapper;
import com.example.demo.repository.FlightRepository;
import com.example.demo.request.FlightRequest;
import com.example.demo.response.FlightResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.demo.constants.ValidationMessages.FLIGHT_ALREADY_EXIST;
import static com.example.demo.constants.ValidationMessages.FLIGHT_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    private final FlightMapper flightMapper;

    public FlightResponse save(FlightRequest flightRequest) {
        findByFlightNUmber(flightRequest);
        FlightEntity validDataForFlightEntity = flightMapper.flightRequestToFlightEntity(flightRequest);
        FlightEntity flightEntity = flightRepository.save(validDataForFlightEntity);
        return flightMapper.flightEntityToFlightResponse(flightEntity);
    }

    public void delete(Long id) {
        Optional<FlightEntity> flightEntityOptional = flightRepository.findById(id);
        flightEntityOptional.ifPresent(flightRepository::delete);
    }

    public List<FlightResponse> allFlights() {
         List<FlightEntity> flightEntityEntities = flightRepository.findAll();
         return flightMapper.flightEntityListToFlightResponse(flightEntityEntities);
    }

    public FlightResponse findById(Long id) {
        return flightMapper.flightEntityToFlightResponse( Optional
                .ofNullable(
                        flightRepository
                                .findById(id)
                                .orElseThrow(() -> new CustomFoundException(FLIGHT_NOT_FOUND))
                )
                .get()
        );
    }

    public Optional<FlightEntity> getFlight(Long id) {
        return flightRepository.findById(id);
    }

    public Optional<FlightEntity> findByFlightNUmber(FlightRequest flightRequest) {
        return Optional
                .ofNullable(
                        flightRepository
                                .findByFlightNumber(flightRequest.getFlightNumber())
                                .orElseThrow(() -> new CustomAlreadyExistException(FLIGHT_ALREADY_EXIST))
                );
    }

}
