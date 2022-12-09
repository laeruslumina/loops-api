package com.loops.loopsapi.user.service;

import com.loops.loopsapi.user.persistence.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link User} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDtoUpdate {
    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String addressAlter;
    private String province;
    private String cities;
    private String postalCode;
    private String country;

    static UserDtoUpdate fromUser(User user){
        return new UserDtoUpdate(user.getId() ,user.getName(), user.getEmail(), user.getPhoneNumber(),
                user.getAddress(), user.getAddressAlter(), user.getProvince(), user.getCities(), user.getPostalCode(), user.getCountry());
    }

    User toEntity(){
        return User
                .builder()
                .name(name)
                .email(email)
                .phoneNumber(phoneNumber)
                .address(address)
                .addressAlter(addressAlter)
                .province(province)
                .cities(cities)
                .postalCode(postalCode)
                .country(country)
                .build();
    }
}