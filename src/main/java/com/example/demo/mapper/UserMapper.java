package com.example.demo.mapper;

import com.example.demo.entity.User;
import com.example.demo.request.UserRequest;
import com.example.demo.request.UserResponse;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User userRequestToUserEntity(UserRequest userRequest);

     List<UserResponse> userEntityListToUserResponseList(List<User> user);

     UserResponse userEntityToUserResponse(User user);

    UserResponse userEntityToUserResponseMapper(Optional<User> user);


}
