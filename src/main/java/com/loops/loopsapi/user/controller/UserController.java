package com.loops.loopsapi.user.controller;

import com.loops.loopsapi.user.service.UserDtoLogin;
import com.loops.loopsapi.user.service.UserDtoRegister;
import com.loops.loopsapi.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDtoRegister register (@RequestBody UserDtoRegister userDtoRegister) throws IllegalAccessException { return userService.registerUser(userDtoRegister);}

    @PostMapping("/user/login")
    public ResponseEntity <Void> login (@RequestBody UserDtoLogin userDtoLogin){
        if (userService.isUserValidLogin(userDtoLogin)){
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{id}")
    public UserDtoRegister findById(@PathVariable Long id){ return userService.findById(id);}
}
