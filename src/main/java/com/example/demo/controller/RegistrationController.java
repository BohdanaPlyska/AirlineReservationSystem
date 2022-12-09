package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.request.UserRegistrationRequest;
import com.example.demo.request.UserRequest;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class RegistrationController {

    private UserService userService;

    private final UserMapper userMapper;

    public RegistrationController(UserService userService, UserMapper userMapper) { //UserService null if we use @RequiredArgsConstructor

        this.userService = userService;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        UserRequest user = userMapper.userRegistrationRequestToUserRequest(userRegistrationRequest);
        userService.findUserByEmail(user);
        userService.save(user);
        return "Success";
    }

}
