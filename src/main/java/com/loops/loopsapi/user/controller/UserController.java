package com.loops.loopsapi.user.controller;

import com.loops.loopsapi.user.dtos.UserDtoLogin;
import com.loops.loopsapi.user.dtos.UserDtoRegister;
import com.loops.loopsapi.user.dtos.UserDtoUpdate;
import com.loops.loopsapi.user.service.*;
import com.loops.loopsapi.utils.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDtoRegister register (@RequestBody UserDtoRegister userDtoRegister) throws IllegalAccessException { return userService.registerUser(userDtoRegister);}

    @PostMapping("/login")
    public APIResponse login (@RequestBody UserDtoLogin userDtoLogin){

        return userService.isUserValidLogin(userDtoLogin);
    }

    @GetMapping("/{id}")
    public UserDtoRegister findById(@PathVariable Long id){ return userService.findById(id);}

    @PutMapping("/update/{id}")
    public  String updateUser(@PathVariable Long id, @RequestBody UserDtoUpdate userDtoUpdate){
        return userService.updateUser(id, userDtoUpdate);
    }
}
