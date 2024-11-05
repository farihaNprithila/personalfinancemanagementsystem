package com.fariha.userservice.common.mapper;

import com.fariha.userservice.data.entity.User;
import com.fariha.userservice.presenter.domain.request.UserRequest;
import com.fariha.userservice.presenter.domain.response.UserResponse;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public abstract class UserMapper {
    public abstract User mapToUser(UserRequest request);

    public abstract UserResponse mapDetailsToUserResponse(User entity);

}
