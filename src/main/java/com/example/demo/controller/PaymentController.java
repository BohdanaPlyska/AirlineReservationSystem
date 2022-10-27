package com.example.demo.controller;



import com.example.demo.entity.PaymentEntity;
import com.example.demo.request.PaymentRequest;
import com.example.demo.request.PaymentResponse;
import com.example.demo.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


import static com.example.demo.constants.DefaultAppConstants.*;

@RestController
@RequestMapping(PAYMENTS_PAGE_URL)
@RequiredArgsConstructor
public class PaymentController {

    public final PaymentService paymentService;

    @PostMapping
    public PaymentResponse savePayment(@RequestBody PaymentRequest request) throws Exception {
        return paymentService.saveAndUpdate(request);
    }

    @DeleteMapping(ID_PAGE_URL)
    public Boolean deletePayment(@PathVariable Long id) {
        paymentService.delete(id);
        if( paymentService.getPayment(id).isPresent()){
            return false;
        } else {
            return true;
        }
    }

    @GetMapping
    public List<PaymentResponse> showAllPayments(){
        List<PaymentResponse> payments = new ArrayList<>();
        paymentService.allPayments().forEach(payments::add);
        return payments;
    }

    @GetMapping(ID_PAGE_URL)
    public PaymentResponse getPayment(@PathVariable Long id) {
        return paymentService.findById(id);
    }
}
