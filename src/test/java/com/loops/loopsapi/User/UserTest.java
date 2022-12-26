package com.loops.loopsapi.User;

import com.loops.loopsapi.user.controller.UserController;
import com.loops.loopsapi.user.dtos.UserDtoGet;
import com.loops.loopsapi.user.dtos.UserDtoLogin;
import com.loops.loopsapi.user.dtos.UserDtoRegister;
import com.loops.loopsapi.user.dtos.UserDtoUpdate;
import com.loops.loopsapi.utils.APIResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserController userController;

    @Test
    void registerTestSuccess() throws IllegalAccessException {
        UserDtoRegister userDtoRegister = new UserDtoRegister();
        userDtoRegister.setName("Pariz Aja");
        userDtoRegister.setEmail("predator@gmail.com");
        userDtoRegister.setPassword("Predator@123");
        userDtoRegister.setPhoneNumber("0833912351912");
        userDtoRegister.setGender("Male");

        UserDtoRegister user = userController.register(userDtoRegister);
        Assertions.assertNotNull(user);
    }

    @Test
    void registerTestFail() throws  IllegalAccessException{
        UserDtoRegister userDtoRegister = new UserDtoRegister();
        userDtoRegister.setName("mcatn");
        userDtoRegister.setEmail("Candraaji@gmail.com");
        userDtoRegister.setPassword("Candra@123");
        userDtoRegister.setPhoneNumber("085791475192");
        userDtoRegister.setGender("Male");

        Exception exception = Assertions.assertThrows(IllegalAccessException.class,() -> userController.register(userDtoRegister));

        String expectedMessage = "Email already exist";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void loginTestPositive(){
        UserDtoLogin userDtoLogin = new UserDtoLogin();
        userDtoLogin.setEmail("Candraaji@gmail.com");
        userDtoLogin.setPassword("Candra@123");
        APIResponse login = userController.login(userDtoLogin);
        Assertions.assertEquals("User Login Success",login.getValid());
    }

    @Test
    void loginTestNegative(){
        UserDtoLogin userDtoLogin = new UserDtoLogin();
        userDtoLogin.setEmail("haha@gmail.com");
        userDtoLogin.setPassword("haha");
        APIResponse login = userController.login(userDtoLogin);
        Assertions.assertEquals("User Login Failed",login.getValid());
    }

    @Test
    void findByIdTestSuccess(){
        UserDtoGet user = userController.findById(1L);
        Assertions.assertNotNull(user);
    }

    @Test
    void findByIdTestFail(){
        Exception exception = Assertions.assertThrows(EntityNotFoundException.class, () -> userController.findById(10L));

        String expectedMessage = "User not found";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void updateTestSuccess(){
        UserDtoUpdate userDtoUpdate = new UserDtoUpdate();
        userDtoUpdate.setAddress("lidah");
        userDtoUpdate.setAddressAlter("wiyung");
        userDtoUpdate.setProvince("jawa timur");
        userDtoUpdate.setCities("sby");
        userDtoUpdate.setPostalCode("60213");
        userDtoUpdate.setCountry("indosiar");

        String user = userController.updateUser(1L,userDtoUpdate);

        Assertions.assertEquals("Success", user);
    }

    @Test
    void updateTestFail(){
        UserDtoUpdate userDtoUpdate = new UserDtoUpdate();
        userDtoUpdate.setAddress("lidah");
        userDtoUpdate.setAddressAlter("wiyung");
        userDtoUpdate.setCities("sby");
        userDtoUpdate.setPostalCode("60213");
        userDtoUpdate.setCountry("indosiar");

        Exception exception = Assertions.assertThrows(EntityNotFoundException.class, () -> userController.updateUser(10L, userDtoUpdate));

        String expectedMessage = "User not found";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }


}
