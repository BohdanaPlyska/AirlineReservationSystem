package com.example.demo.mapper;

import com.example.demo.entity.DiscountProgram;
import com.example.demo.entity.Ticket;
import com.example.demo.request.DiscountProgramRequest;
import com.example.demo.request.DiscountProgramResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DiscountProgramMapper {

    DiscountProgram discountProgramRequestToDiscountProgramEntity(DiscountProgramRequest request, Ticket ticket);

    DiscountProgramResponse discountProgramEntityToDiscountProgramResponse(DiscountProgram entity);

    List<DiscountProgramResponse> discountProgramEntityListToDiscountProgramResponseList(List<DiscountProgram> entityList);

}
