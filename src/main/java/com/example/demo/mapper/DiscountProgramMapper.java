package com.example.demo.mapper;

import com.example.demo.entity.DiscountProgramEntity;
import com.example.demo.entity.TicketEntity;
import com.example.demo.request.DiscountProgramRequest;
import com.example.demo.request.DiscountProgramResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiscountProgramMapper {

    DiscountProgramEntity discountProgramRequestToDiscountProgramEntity(DiscountProgramRequest request, TicketEntity ticket);

    DiscountProgramResponse discountProgramEntityToDiscountProgramResponse(DiscountProgramEntity entity);

    List<DiscountProgramResponse> discountProgramEntityListToDiscountProgramResponseList(List<DiscountProgramEntity> entityList);

}
