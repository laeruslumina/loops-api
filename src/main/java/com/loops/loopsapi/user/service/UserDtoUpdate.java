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
    private Long userId;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String addressAlter;
    private String province;
    private String cities;
    private String postalCode;
    private String country;
}