package com.loops.loopsapi.user.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.loops.loopsapi.annotation.ValidPassword;
import com.loops.loopsapi.user.persistence.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * A DTO for the {@link User} entity
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Valid
public class UserDtoRegister {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long userId;

    @NotEmpty(message = "Name is Mandatory")
    private String name;

    @Email(message = "Wrong email format", regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")
    private String email;

    @ValidPassword
    @NotEmpty
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String password;

    @NotEmpty(message = "phoneNumber is Mandatory")
    private String phoneNumber;

    @NotEmpty(message = "gender is Mandatory")
    private String gender;

    @Column(columnDefinition = "decimal(19,2)")
    private BigDecimal balance = BigDecimal.ZERO;

    public static UserDtoRegister fromUser(User user) { //request body
        return new UserDtoRegister(user.getUserId(), user.getName(), user.getEmail(), null, user.getPhoneNumber(), user.getGender(),user.getBalance());
    }

    public User toEntity(){ //penyimpanan ke database
        return User.builder()
                .name(name)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .gender(gender)
                .balance(balance)
                .build();
    }
}