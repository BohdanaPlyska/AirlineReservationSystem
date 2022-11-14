package com.example.demo.mapper;

import com.example.demo.entity.UserEntity;
import com.example.demo.request.UserRequest;
import com.example.demo.response.UserResponse;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserEntity userRequestToUserEntity(UserRequest userRequest);

     List<UserResponse> userEntityListToUserResponseList(List<UserEntity> userEntity);

     UserResponse userEntityToUserResponse(UserEntity userEntity);

    UserResponse userEntityToUserResponseMapper(Optional<UserEntity> user);

}
