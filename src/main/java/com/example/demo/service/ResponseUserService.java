package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResponseUserService {

    public List<String> getAllErrors(Errors error) {
        return error.getAllErrors()
                    .stream()
                        .map(Object::toString)
                        .collect(Collectors.toList()
                );
    }

}
