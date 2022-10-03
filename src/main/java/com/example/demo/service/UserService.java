package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveAndUpdate(User user);

    void delete (Long id);

    List<User> findAll();

    User findById(Long id);

    Optional<User> getUser(Long id);
}
