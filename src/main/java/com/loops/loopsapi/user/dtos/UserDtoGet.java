package com.loops.loopsapi.user.dtos;

import com.loops.loopsapi.user.persistence.User;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * A DTO for the {@link User} entity
 */

@Data
@AllArgsConstructor
public class UserDtoGet {
    private Long userId;
    private String name;
    private String email;
    private String phoneNumber;
    private String gender;
    private String address;
    private String addressAlter;
    private String province;
    private String cities;
    private String postalCode;
    private String country;

    public static UserDtoGet fromUser(User user){
        return new UserDtoGet(user.getUserId(),user.getName(),user.getEmail(),user.getPhoneNumber(),user.getGender()
        ,user.getAddress(),user.getAddressAlter(),user.getProvince(),user.getCities(),user.getPostalCode()
        ,user.getCountry());
    }
}
