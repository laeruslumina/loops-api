package com.loops.loopsapi.user.service;

import com.loops.loopsapi.user.persistence.User;
import com.loops.loopsapi.user.persistence.UserRepository;
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
            throw new IllegalAccessException("Username is already exist");
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
        } else {
            apiResponse.setValid("User Login Failed");
        }
        return apiResponse;
    }

    @Override
    public UserDtoRegister findById(Long id) {
        return userRepository.findById(id)
                .map(UserDtoRegister::fromUser)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public String updateUser(Long id, UserDtoUpdate userDtoUpdate) {
        User original = userRepository.findById(id).orElse(null);
            if (original != null){
//         Normal if - else
//            if (userDtoUpdate.getName() != null){original.setName(userDtoUpdate.getName());}
//            Using ternary
            original.setName(userDtoUpdate.getName() != null ? userDtoUpdate.getName() : original.getName());
//            if (userDtoUpdate.getEmail() != null){original.setEmail(userDtoUpdate.getEmail());}
            original.setEmail(userDtoUpdate.getEmail() != null ? userDtoUpdate.getEmail() : original.getEmail());
//            if (userDtoUpdate.getPhoneNumber() != null){original.setPhoneNumber(userDtoUpdate.getPhoneNumber());}
            original.setPhoneNumber(userDtoUpdate.getPhoneNumber() != null ? userDtoUpdate.getPhoneNumber() : original.getPhoneNumber());
//            if (userDtoUpdate.getAddress() != null){original.setAddress(userDtoUpdate.getAddress());}
            original.setAddress(userDtoUpdate.getAddress() != null ? userDtoUpdate.getAddress() : original.getAddress());
//            if (userDtoUpdate.getAddressAlter() != null){original.setAddressAlter(userDtoUpdate.getAddressAlter());}
            original.setAddressAlter(userDtoUpdate.getAddressAlter() != null ? userDtoUpdate.getAddressAlter() : original.getAddressAlter());
//            if (userDtoUpdate.getProvince() != null){original.setProvince(userDtoUpdate.getProvince());}
            original.setProvince(userDtoUpdate.getProvince() != null ? userDtoUpdate.getProvince() : original.getProvince());
//            if (userDtoUpdate.getCities() != null){original.setCities(userDtoUpdate.getCities());}
            original.setCities(userDtoUpdate.getCities() != null ? userDtoUpdate.getCities() : original.getCities());
//            if (userDtoUpdate.getPostalCode() != null){original.setPostalCode(userDtoUpdate.getPostalCode());}
            original.setPostalCode(userDtoUpdate.getPostalCode() != null ? userDtoUpdate.getPostalCode() : original.getPostalCode());
//            if (userDtoUpdate.getCountry() != null){original.setCountry(userDtoUpdate.getCountry());}
            original.setCountry(userDtoUpdate.getCountry() != null ? userDtoUpdate.getCountry() : original.getCountry());
            } else {
                new EntityNotFoundException("Data does not exist");
            }
            userRepository.save(original);
        return "Success";
    }
}
