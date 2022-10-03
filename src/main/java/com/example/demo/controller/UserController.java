package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.constants.DefaultAppConstants.*;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(USER_SAVE_USER_PAGE_URL)
    public ResponseEntity<User> saveAndUpdate(@RequestBody User user) {
        return new ResponseEntity<>(userService.saveAndUpdate(user), HttpStatus.CREATED);
    }

    @DeleteMapping(USER_DELETE_PAGE_URL)
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {
        userService.delete(id);
        if (userService.getUser(id).isPresent()) {
            return new ResponseEntity<>(false,HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
    }

    @GetMapping(USERS_PAGE_URL)
    public ResponseEntity<List<User>> showAllUsers() {
        List<User> users = new ArrayList<>();
        userService.findAll().forEach(users::add);
        return ResponseEntity.ok(users);
    }

    @GetMapping(USER_GET_USER_PAGE_URL)
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }


}
