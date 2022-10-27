package com.example.demo.controller;

import com.example.demo.entity.DiscountProgramEntity;
import com.example.demo.request.DiscountProgramRequest;
import com.example.demo.request.DiscountProgramResponse;
import com.example.demo.service.DiscountProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.constants.DefaultAppConstants.DISCOUNT_PROGRAM_PAGE_URL;
import static com.example.demo.constants.DefaultAppConstants.ID_PAGE_URL;

@RestController
@RequiredArgsConstructor
@RequestMapping(DISCOUNT_PROGRAM_PAGE_URL)
public class DiscountProgramController {

    private final DiscountProgramService discountService;

    @PostMapping
    public DiscountProgramResponse saveAndUpdate(@RequestBody DiscountProgramRequest discountProgram){
        return discountService.saveAndUpdate(discountProgram);
    }

    @DeleteMapping(ID_PAGE_URL)
    public Boolean delete(@PathVariable Long id) {
        discountService.delete(id);
        if (discountService.getDiscount(id).isPresent()){
            return false;
        } else {
            return true;
        }
    }

    @GetMapping
    public List<DiscountProgramResponse> showAllDiscount(){
        List<DiscountProgramResponse> discountProgramEntities = new ArrayList<>();
        discountService.allDiscounts().forEach(discountProgramEntities::add);
        return discountProgramEntities;
    }

    @GetMapping(ID_PAGE_URL)
    public  DiscountProgramResponse getDiscount(@PathVariable Long id) {
        return discountService.findById(id);
    }

}
