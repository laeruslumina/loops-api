package com.loops.loopsapi.topup.dtos;

import com.loops.loopsapi.user.persistence.User;
import lombok.Data;

import java.math.BigDecimal;

/**
 * A DTO for the {@link User} entity
 */

@Data
public class TopUpDto {

    private Long userId;

    private BigDecimal balance;

}
