package com.example.demo.service;

import com.example.demo.entity.ReservationEntity;
import com.example.demo.mapper.ReservationMapper;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.request.ReservationRequest;
import com.example.demo.request.ReservationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    private final ReservationMapper reservationMapper;

//    public ReservationResponse saveAndUpdate(ReservationRequest request) {
//        ReservationEntity validDataForReservation = reservationMapper.reservationRequestToReservationEntity(request);
//        ReservationEntity reservationEntity = reservationRepository.save(validDataForReservation);
//        return reservationMapper.reservationEntityToReservationRequest(reservationEntity);
//    }
}
