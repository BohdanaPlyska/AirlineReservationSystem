package com.example.demo.service;

import com.example.demo.entity.Role;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.CustomFoundException;
import com.example.demo.exception.CustomAlreadyExistException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.request.UserRequest;
import com.example.demo.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

import static com.example.demo.constants.UrlPagesConstants.*;
import static com.example.demo.constants.ValidationMessages.USER_ALREADY_EXIST;
import static com.example.demo.constants.ValidationMessages.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostConstruct
    public void postConstruct() {
        Optional<UserEntity> user = userRepository.findById(DEFAULT_USER_ADMIN_ID);
        if (user.isEmpty()) {
            UserEntity admin = new UserEntity();
            admin.setId(DEFAULT_USER_ADMIN_ID);
            admin.setUserName(DEFAULT_USER_NAME_ADMIN);
            admin.setRole(Role.ROLE_ADMIN);
            admin.setPassword(bCryptPasswordEncoder.encode(DEFAULT_USER_PASSWORD_FOR_ADMIN));
            admin.setEmail(DEFAULT_USER_ADMIN_EMAIL);
            admin.setFirstName("Bohdana");
            admin.setLastName("Ford");
            admin.setPhoneNumber("+380967548484");
            userRepository.save(admin);
        }
    }

    public UserResponse save(UserRequest user) {
        findUserByEmail(user);
        if(user.getPassword() != null) {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        }
        user.setActive(true);
        user.setRole(Role.ROLE_USER);

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
            throw new CustomAlreadyExistException(USER_ALREADY_EXIST+"!");
        }
        return userOptional;
//        Optional
//                .ofNullable(
//                        userRepository
//                                .findByEmail(user.getEmail())
//                                .orElseThrow(() -> new CustomAlreadyExistException(USER_ALREADY_EXIST))
//                );
    }

    public  UserResponse findById(Long id) {
        return userMapper.userEntityToUserResponse(Optional
                .ofNullable(
                        userRepository
                                .findById(id)
                                .orElseThrow(() -> new CustomFoundException(USER_NOT_FOUND)))
                .get()
        );
    }

}
