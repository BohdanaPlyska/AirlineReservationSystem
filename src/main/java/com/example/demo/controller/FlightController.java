package com.example.demo.controller;


import com.example.demo.request.FlightRequest;
import com.example.demo.request.FlightResponse;
import com.example.demo.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.constants.DefaultAppConstants.*;

@RestController
@RequestMapping(FLIGHTS_PAGE_URL)
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @PostMapping
    public FlightResponse saveAndUpdate(@RequestBody FlightRequest flight) {
        return flightService.saveAndUpdate(flight);
    }

    @DeleteMapping(ID_PAGE_URL)
    public Boolean delete(@PathVariable Long id) {
        flightService.delete(id);
        if(flightService.getFlight(id).isPresent()) {
            return false;
        } else {
            return true;
        }
    }

    @GetMapping
    public List<FlightResponse> getAllFlights() {
        List<FlightResponse> flights = new ArrayList<>();
        flightService.allFlights().forEach(flights::add);
        return flights;
    }

    @GetMapping(ID_PAGE_URL)
    public FlightResponse getFlight(@PathVariable Long id) {
        return flightService.findById(id);
    }


}
