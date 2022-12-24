package com.loops.loopsapi;

import com.loops.loopsapi.user.controller.UserController;
import com.loops.loopsapi.user.dtos.UserDtoLogin;
import com.loops.loopsapi.utils.APIResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoginTest {

    @Autowired
    UserController userController;

    @Test
    public void loginTestPositive1() throws Exception{
        UserDtoLogin userDtoLogin = new UserDtoLogin();
        userDtoLogin.setEmail("fuad@gmail.com");
        userDtoLogin.setPassword("Akufuad99@");
        APIResponse login = userController.login(userDtoLogin);
        Assertions.assertEquals("User Login Success",login.getValid());
    }

    @Test
    public void loginTestNegative1() throws Exception{
        UserDtoLogin userDtoLogin = new UserDtoLogin();
        userDtoLogin.setEmail("fuad@gmail.com");
        userDtoLogin.setPassword("Akufuad99@");
        APIResponse login = userController.login(userDtoLogin);
        Assertions.assertEquals("User Login Success",login.getValid());
    }

    @Test
    public void loginTestNegative2() throws Exception{
        UserDtoLogin userDtoLogin = new UserDtoLogin();
        userDtoLogin.setEmail("fuad@gmail.com");
        userDtoLogin.setPassword("akufuad99");
        APIResponse login = userController.login(userDtoLogin);
        Assertions.assertEquals("User Login Failed",login.getValid());
    }

}
