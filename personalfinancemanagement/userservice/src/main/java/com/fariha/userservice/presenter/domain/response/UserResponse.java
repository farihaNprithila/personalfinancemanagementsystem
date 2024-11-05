package com.fariha.userservice.presenter.domain.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {

    private String username;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

}
