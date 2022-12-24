package com.loops.loopsapi.user.service;


import com.loops.loopsapi.user.dtos.UserDtoLogin;
import com.loops.loopsapi.user.dtos.UserDtoRegister;
import com.loops.loopsapi.user.dtos.UserDtoUpdate;
import com.loops.loopsapi.utils.APIResponse;

import javax.validation.Valid;

public interface UserService {

    UserDtoRegister registerUser(@Valid UserDtoRegister userDtoRegister) throws IllegalAccessException;
    APIResponse isUserValidLogin(UserDtoLogin userDtoLogin);
    UserDtoRegister findById(Long id);
    String updateUser(Long id, UserDtoUpdate userDtoUpdate);

}
