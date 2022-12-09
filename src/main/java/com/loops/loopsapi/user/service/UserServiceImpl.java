package com.loops.loopsapi.user.service;

import com.loops.loopsapi.user.persistence.User;
import com.loops.loopsapi.user.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    private final BCryptPasswordEncoder passwordEncoder;

    private void validateUserExist(String email) throws IllegalAccessException {
        if (userRepository.existsByEmail(email)){
            throw new IllegalAccessException("Username is already exist");
        }
    }

    private User saveUser(UserDtoRegister userDtoRegister){
        String encryptedPassword = passwordEncoder.encode(userDtoRegister.getPassword());

        return userRepository.save(userDtoRegister.toEntity(encryptedPassword));
    }

    @Override
    public UserDtoRegister registerUser(@Valid UserDtoRegister userDtoRegister) throws IllegalAccessException {
        validateUserExist(userDtoRegister.getEmail());
        User user = saveUser(userDtoRegister);

        return UserDtoRegister.fromUser(user);
    }

    @Override
    public boolean isUserValidLogin(UserDtoLogin userDtoLogin) {
        return userRepository
                .findByEmail(userDtoLogin.getEmail())
                .filter(user -> passwordEncoder.matches(userDtoLogin.getPassword(), user.getPassword()))
                .isPresent();
    }

    @Override
    public UserDtoRegister findById(Long id) {
        return userRepository.findById(id)
                .map(UserDtoRegister::fromUser)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
    }

    @Override
    public String updateUser(Long id, UserDtoUpdate userDtoUpdate) {
        User original = userRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("User not found"));
            if (userDtoUpdate.getName() != null){
                original.setName(userDtoUpdate.getName());
            }
            if (userDtoUpdate.getEmail() != null){
                original.setEmail(userDtoUpdate.getEmail());
            }
            if (userDtoUpdate.getPhoneNumber() != null){
                original.setPhoneNumber(userDtoUpdate.getPhoneNumber());
            }
            if (userDtoUpdate.getAddress() != null){
                original.setAddress(userDtoUpdate.getAddress());
            }
            if (userDtoUpdate.getAddressAlter() != null){
                original.setAddressAlter(userDtoUpdate.getAddressAlter());
            }
            if (userDtoUpdate.getProvince() != null){
                original.setProvince(userDtoUpdate.getProvince());
            }
            if (userDtoUpdate.getCities() != null){
                original.setCities(userDtoUpdate.getCities());
            }
            if (userDtoUpdate.getPostalCode() != null){
                original.setPostalCode(userDtoUpdate.getPostalCode());
            }
            if (userDtoUpdate.getCountry() != null){
                original.setCountry(userDtoUpdate.getCountry());
            }

            userRepository.save(original);
        return "Success";
    }
}
