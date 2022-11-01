package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.CustomFoundException;
import com.example.demo.exception.CustomAlreadyExistException;
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

    public User save(UserRequest user) {
        Optional<User> userOptional = userRepository.findByUserFirstNameAndLastName(user.getFirstName(), user.getLastName());
        if(userOptional.isPresent()) {
            throw new CustomAlreadyExistException("User already exist");
        }
        return userRepository.save(userMapper.userRequestToUserEntity(user));
    }

    public void delete(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        userOptional.ifPresent(userRepository::delete);
    }

    public List<UserResponse> allUsers() {
        List<User> userList = userRepository.findAll();
        return userMapper.userEntityListToUserResponseList(userList);
    }

    public UserResponse findById(Long id) {
         Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw  new CustomFoundException("User not found");
        }
        return userMapper.userEntityToUserResponse(user.get());
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public UserResponse findByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        return userMapper.userEntityToUserResponseMapper(optionalUser);
    }

    public UserResponse findByFirstName(String firstName) {
        Optional<User> optionalUser = userRepository.findByFirstName(firstName);
        return userMapper.userEntityToUserResponseMapper(optionalUser);
    }
}
