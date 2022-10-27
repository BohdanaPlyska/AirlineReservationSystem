package com.example.demo.controller;

import com.example.demo.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "reservations")
public class ReservationController {
    private final ReservationService reservationService;

//    @PostMapping
//    public ReservationResponse saveAndUpdate(@RequestBody ReservationRequest request) {
//        return reservationService.saveAndUpdate(request);
//    }

}
