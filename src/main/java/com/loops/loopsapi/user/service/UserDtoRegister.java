package com.loops.loopsapi.user.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.loops.loopsapi.user.persistence.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * A DTO for the {@link User} entity
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoRegister {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 8, message = "Password min 8 char")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String gender;

    static UserDtoRegister fromUser (User user) {
        return new UserDtoRegister(user.getId(), user.getName(), user.getEmail(), null, user.getPhoneNumber(), user.getGender());
    }

    User toEntity(String encryptedPassword){
        return User.builder()
                .name(name)
                .email(email)
                .password(encryptedPassword)
                .phoneNumber(phoneNumber)
                .gender(gender)
                .build();
    }
}