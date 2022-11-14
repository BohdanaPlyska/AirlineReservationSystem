package com.example.demo.mapper;

import com.example.demo.entity.DiscountProgramEntity;
import com.example.demo.entity.TicketEntity;
import com.example.demo.request.DiscountProgramRequest;
import com.example.demo.response.DiscountProgramResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiscountProgramMapper {

    DiscountProgramEntity discountProgramRequestToDiscountProgramEntity(DiscountProgramRequest request, TicketEntity ticketEntity);

    DiscountProgramResponse discountProgramEntityToDiscountProgramResponse(DiscountProgramEntity entity);

    List<DiscountProgramResponse> discountProgramEntityListToDiscountProgramResponseList(List<DiscountProgramEntity> entityList);

}
