package com.example.demo.controller;


import com.example.demo.request.FlightRequest;
import com.example.demo.response.FlightResponse;
import com.example.demo.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.demo.constants.UrlPagesConstants.*;

@RestController
@RequestMapping(FLIGHTS_PAGE_URL)
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @PostMapping
    public FlightResponse save(@RequestBody @Valid FlightRequest flight) {
        return flightService.save(flight);
    }

    @DeleteMapping(ID_PAGE_URL)
    public Boolean delete(@PathVariable Long id) {
        flightService.delete(id);
        return flightService.getFlight(id).isEmpty();
    }

    @GetMapping
    public List<FlightResponse> getAllFlights() {
        return flightService.allFlights();
    }

    @GetMapping(ID_PAGE_URL)
    public FlightResponse getFlight(@PathVariable Long id) {
        return flightService.findById(id);
    }

}
