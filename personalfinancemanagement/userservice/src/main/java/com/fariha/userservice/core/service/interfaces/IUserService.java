package com.fariha.userservice.core.service.interfaces;

import com.fariha.userservice.presenter.domain.request.UserRequest;
import com.fariha.userservice.presenter.domain.response.UserResponse;

public interface IUserService {
    void createUser(UserRequest request) throws Exception;

    void updateUser(UserRequest request) throws Exception;

    UserResponse getUserDetails(String userName) throws Exception;

    void deleteUser(String userName) throws Exception;
}
