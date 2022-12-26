package com.loops.loopsapi.topup.dtos;

import com.loops.loopsapi.topup.persistence.entity.BankList;
import lombok.Data;

/**
 * A DTO for the {@link BankList} entity
 */
@Data
public class BankListDtoCheck {
    private Long virtualAcc;
}