package com.loops.loopsapi.user.service;

import com.loops.loopsapi.user.persistence.User;

import lombok.Data;


/**
 * A DTO for the {@link User} entity
 */

@Data
public class UserDtoLogin {

    private String email;

    private String password;

}
