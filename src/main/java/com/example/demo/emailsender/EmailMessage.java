package com.example.demo.emailsender;

import lombok.Data;

import java.util.Map;

@Data
public class EmailMessage {

    private String to;

    private String subject;

    private String message;

    private Map<String, Object> model;

}
