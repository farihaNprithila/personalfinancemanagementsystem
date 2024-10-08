package com.fariha.userservice.presenter.rest.api;

import com.fariha.userservice.common.utils.AppUtils;
import com.fariha.userservice.common.utils.MessageUtils;
import com.fariha.userservice.core.service.interfaces.IUserService;
import com.fariha.userservice.presenter.domain.request.UserRequest;
import com.fariha.userservice.presenter.domain.response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppUtils.BASE_URL)
public class UserResource {

    private final IUserService userService;

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody @Valid UserRequest request) throws Exception {
        userService.createUser(request);
        return ResponseEntity.ok(MessageUtils.OPERATION_SUCCESSFUL);
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody @Valid UserRequest request) throws Exception {
        userService.updateUser(request);
        return ResponseEntity.ok(MessageUtils.OPERATION_SUCCESSFUL);
    }

    @GetMapping("/details/{userName}")
    public ResponseEntity<UserResponse> getUserDetails(@PathVariable String userName) throws Exception {
        UserResponse response=userService.getUserDetails(userName);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/delete/{userName}")
    public ResponseEntity<?> deleteUser(@PathVariable String userName) throws Exception {
        userService.deleteUser(userName);
        return ResponseEntity.ok(MessageUtils.OPERATION_SUCCESSFUL);
    }
}
