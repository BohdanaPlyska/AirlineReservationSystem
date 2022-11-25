package com.example.demo.emailsender;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send-email")
    public ResponseEntity sendEmailMessage1(@RequestBody EmailMessage emailMessage) {
     this.emailService.sendMessage(
             emailMessage.getTo(),
             emailMessage.getSubject(),
             emailMessage.getMessage()
             );
     return ResponseEntity.ok("Success");
    }

}
