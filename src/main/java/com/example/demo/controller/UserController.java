package com.example.demo.controller;

import com.example.demo.response.BaseResponse;
import com.example.demo.request.UserRequest;
import com.example.demo.response.UserResponse;
import com.example.demo.service.ResponseUserService;
import com.example.demo.service.UserService;
import com.example.demo.validator.UserValidator;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.example.demo.constants.UrlPagesConstants.*;

@RestController
@RequestMapping(value = USERS_PAGE_URL)
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;
    private final ResponseUserService responseUserService;

    @PostMapping
    public ResponseEntity<BaseResponse> save(@Valid @RequestBody UserRequest request, Errors error)  {
        userValidator.validate(request,error);
        if(error.hasErrors()) {
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setErrors(responseUserService.getAllErrors(error));
              return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userService.save(request), HttpStatus.OK);
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
