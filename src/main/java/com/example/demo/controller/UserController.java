package com.example.demo.controller;

import com.example.demo.entity.UserEntity;
import com.example.demo.request.UserRequest;
import com.example.demo.request.UserResponse;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.constants.DefaultAppConstants.*;

@RestController
@RequestMapping(value = USERS_PAGE_URL)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserEntity saveAndUpdateUser(@RequestBody UserRequest request) {
        return userService.saveAndUpdate(request);
    }

    @DeleteMapping(ID_PAGE_URL)
    public Boolean deleteUser(@PathVariable Long id) {
        userService.delete(id);
        if (userService.getUser(id).isPresent()) {
            return false;
        } else {
            return true;
        }
    }

    @GetMapping
    public List<UserResponse> showAllUsers() {
        return userService.allUsers();

    }

    @GetMapping(ID_PAGE_URL)
    public UserResponse getUser(@PathVariable Long id) {
        return userService.findById(id);
    }


}
