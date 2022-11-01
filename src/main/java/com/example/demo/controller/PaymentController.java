package com.example.demo.controller;

import com.example.demo.request.PaymentRequest;
import com.example.demo.request.PaymentResponse;
import com.example.demo.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.demo.constants.DefaultAppConstants.*;

@RestController
@RequestMapping(PAYMENTS_PAGE_URL)
@RequiredArgsConstructor
public class PaymentController {

    public final PaymentService paymentService;

    @PostMapping
    public PaymentResponse save(@RequestBody @Valid PaymentRequest request) {
        return paymentService.save(request);
    }

    @DeleteMapping(ID_PAGE_URL)
    public Boolean deletePayment(@PathVariable Long id) {
        paymentService.delete(id);
        return paymentService.getPayment(id).isEmpty();
    }

    @GetMapping
    public List<PaymentResponse> showAllPayments(){
        return paymentService.allPayments();
    }

    @GetMapping(ID_PAGE_URL)
    public PaymentResponse getPayment(@PathVariable Long id) {
        return paymentService.findById(id);
    }
}
