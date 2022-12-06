package com.loops.loopsapi.user.service;

import com.loops.loopsapi.topup.service.TopUpDto;
import com.loops.loopsapi.user.persistence.User;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

public interface UserService {

    UserDtoRegister registerUser(@Valid UserDtoRegister userDtoRegister) throws IllegalAccessException;

    boolean isUserValidLogin(UserDtoLogin userDtoLogin);

    UserDtoRegister findById(Long id);
}
