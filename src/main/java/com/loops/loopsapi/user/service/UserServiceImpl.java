package com.loops.loopsapi.user.service;

import com.loops.loopsapi.user.dtos.UserDtoGet;
import com.loops.loopsapi.user.dtos.UserDtoLogin;
import com.loops.loopsapi.user.dtos.UserDtoRegister;
import com.loops.loopsapi.user.dtos.UserDtoUpdate;
import com.loops.loopsapi.user.persistence.User;
import com.loops.loopsapi.user.persistence.UserRepository;
import com.loops.loopsapi.utils.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

@Service
@RequiredArgsConstructor
@Validated
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;

//    private final BCryptPasswordEncoder passwordEncoder;

    private void validateUserExist(String email) throws IllegalAccessException {
        if (userRepository.existsByEmail(email)){
            throw new IllegalAccessException("Email already exist");
        }
    }

    private User saveUser(UserDtoRegister userDtoRegister){
//        String encryptedPassword = passwordEncoder.encode(userDtoRegister.getPassword());
        //better di lihatkan
        return userRepository.save(userDtoRegister.toEntity());
    }

    @Override
    public UserDtoRegister registerUser(@Valid UserDtoRegister userDtoRegister) throws IllegalAccessException {
        //Diliatin prosesnya
        validateUserExist(userDtoRegister.getEmail());
        User user = saveUser(userDtoRegister);

        return UserDtoRegister.fromUser(user);
    }

    @Override
    public APIResponse isUserValidLogin(UserDtoLogin userDtoLogin) {
        User user = userRepository.findByEmail(userDtoLogin.getEmail()).orElse(null);
        APIResponse apiResponse = new APIResponse();
        if (user != null && user.getPassword().equalsIgnoreCase(userDtoLogin.getPassword())) {
            apiResponse.setValid("User Login Success");
            apiResponse.setUserId(user.getUserId());
        } else {
            apiResponse.setValid("User Login Failed");
        }
        return apiResponse;
    }

    @Override
    public UserDtoGet findById(Long id) {
        return userRepository.findById(id)
                .map(UserDtoGet::fromUser)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public String updateUser(Long id, UserDtoUpdate userDtoUpdate) {
        User original = userRepository.findById(id).orElse(null);
            if (original != null){
            original.setName(userDtoUpdate.getName() != null ? userDtoUpdate.getName() : original.getName());
            original.setEmail(userDtoUpdate.getEmail() != null ? userDtoUpdate.getEmail() : original.getEmail());
            original.setPhoneNumber(userDtoUpdate.getPhoneNumber() != null ? userDtoUpdate.getPhoneNumber() : original.getPhoneNumber());
            original.setAddress(userDtoUpdate.getAddress() != null ? userDtoUpdate.getAddress() : original.getAddress());
            original.setAddressAlter(userDtoUpdate.getAddressAlter() != null ? userDtoUpdate.getAddressAlter() : original.getAddressAlter());
            original.setProvince(userDtoUpdate.getProvince() != null ? userDtoUpdate.getProvince() : original.getProvince());
            original.setCities(userDtoUpdate.getCities() != null ? userDtoUpdate.getCities() : original.getCities());
            original.setPostalCode(userDtoUpdate.getPostalCode() != null ? userDtoUpdate.getPostalCode() : original.getPostalCode());
            original.setCountry(userDtoUpdate.getCountry() != null ? userDtoUpdate.getCountry() : original.getCountry());
            } else {
                throw new EntityNotFoundException("User not found");
            }
            userRepository.save(original);
        return "Success";
    }
}
