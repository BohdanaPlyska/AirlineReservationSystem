package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.request.UserRequest;
import com.example.demo.request.UserResponse;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.demo.constants.DefaultAppConstants.*;

@RestController
@RequestMapping(value = USERS_PAGE_URL)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User save( @RequestBody @Valid UserRequest request) {
        return userService.save(request);
    }

    @DeleteMapping(ID_PAGE_URL)
    public Boolean deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return userService.getUser(id).isEmpty();
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
