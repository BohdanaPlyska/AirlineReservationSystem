package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.UserRequest;
import com.example.demo.request.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserEntity saveAndUpdate(UserRequest user) {
        return userRepository.save(userMapper.userRequestToUserEntity(user));
    }

    public void delete(Long id) {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        userOptional.ifPresent(userRepository::delete);
    }

    public List<UserResponse> allUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        return userMapper.userEntityListToUserResponseList(userEntityList);
    }

    public UserResponse findById(Long id) {
        return userMapper.userEntityToUserResponse(userRepository.findById(id).get());
    }

    public Optional<UserEntity> getUser(Long id) {
        return userRepository.findById(id);
    }

}
