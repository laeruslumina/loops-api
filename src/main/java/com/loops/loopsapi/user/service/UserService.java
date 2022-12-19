package com.loops.loopsapi.user.service;


import javax.validation.Valid;

public interface UserService {

    UserDtoRegister registerUser(@Valid UserDtoRegister userDtoRegister) throws IllegalAccessException;
    APIResponse isUserValidLogin(UserDtoLogin userDtoLogin);
    UserDtoRegister findById(Long id);
    String updateUser(Long id,UserDtoUpdate userDtoUpdate);

}
