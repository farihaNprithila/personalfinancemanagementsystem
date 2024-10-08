package com.fariha.userservice.core.service.implementation;

import com.fariha.userservice.common.mapper.UserMapper;
import com.fariha.userservice.common.utils.MessageUtils;
import com.fariha.userservice.core.service.interfaces.IUserService;
import com.fariha.userservice.data.entity.User;
import com.fariha.userservice.data.repository.UserRepository;
import com.fariha.userservice.presenter.domain.request.UserRequest;
import com.fariha.userservice.presenter.domain.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;


@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public void createUser(UserRequest request) throws Exception {
        validateCreateRequest(request);

        User user = userMapper.mapToUser(request);
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void updateUser(UserRequest request) throws Exception {
        validateUpdateRequest(request);

        User user = userMapper.mapToUser(request);
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserDetails(String userName) throws Exception {
        User user = userRepository.findByUsername(userName);
        if (Objects.isNull(user)) {
            throw new Exception(MessageUtils.USER_DOESNOT_EXISTS);
        }
        return userMapper.mapDetailsToUserResponse(user);
    }

    @Override
    public void deleteUser(String userName) throws Exception {
        User user = userRepository.findByUsername(userName);
        if (Objects.isNull(user)) {
            throw new Exception(MessageUtils.USER_DOESNOT_EXISTS);
        }

        userRepository.delete(user);
    }

    private void validateCreateRequest(UserRequest request) throws Exception {
        User user = userRepository.findByUsername(request.getUsername());
        if (!Objects.isNull(user)) {
            throw new Exception(MessageUtils.USER_EXISTS);
        }

        user = userRepository.findByEmail(request.getEmail());
        if (!Objects.isNull(user)) {
            throw new Exception(MessageUtils.USER_EXISTS);
        }
    }

    private void validateUpdateRequest(UserRequest request) throws Exception {
        User user = userRepository.findByUsername(request.getUsername());
        if (Objects.isNull(user)) {
            throw new Exception(MessageUtils.USER_DOESNOT_EXISTS);
        }
    }
}
