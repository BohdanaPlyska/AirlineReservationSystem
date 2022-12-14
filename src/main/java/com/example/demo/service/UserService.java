package com.example.demo.service;

import com.example.demo.entity.UserEntity;
import com.example.demo.exception.CustomFoundException;
import com.example.demo.exception.CustomAlreadyExistException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.UserRequest;
import com.example.demo.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.demo.constants.ValidationMessages.USER_ALREADY_EXIST;
import static com.example.demo.constants.ValidationMessages.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserResponse save(UserRequest user) {
        findUserByEmail(user);
        UserEntity validDataForUser = userMapper.userRequestToUserEntity(user);
        UserEntity userEntity = userRepository.save(validDataForUser);
        return userMapper.userEntityToUserResponse(userEntity);
    }

    public void delete(Long id) {
        Optional<UserEntity> userOptional = userRepository.findById(id);
        userOptional.ifPresent(userRepository::delete);
    }

    public List<UserResponse> allUsers() {
        List<UserEntity> userEntityList = userRepository.findAll();
        return userMapper.userEntityListToUserResponseList(userEntityList);
    }

    public Optional<UserEntity> getUser(Long id) {
        return userRepository.findById(id);
    }

    public  Optional<UserEntity> findUserByEmail(UserRequest user) {
        Optional<UserEntity> userOptional = userRepository.findByEmail(user.getEmail());
        if(userOptional.isPresent()) {
            throw new CustomAlreadyExistException(USER_ALREADY_EXIST);
        }
        return userOptional;
    }

    public  UserResponse findById(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw  new CustomFoundException(USER_NOT_FOUND);
        }
        return userMapper.userEntityToUserResponse(user.get());
    }
}
