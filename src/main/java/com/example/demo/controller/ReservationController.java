package com.example.demo.controller;

import com.example.demo.request.ReservationRequest;
import com.example.demo.request.ReservationResponse;
import com.example.demo.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.example.demo.constants.DefaultAppConstants.RESERVATION_PAGE_URL;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = RESERVATION_PAGE_URL)
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ReservationResponse save(@RequestBody @Valid ReservationRequest request) {
        return reservationService.save(request);
    }

}
