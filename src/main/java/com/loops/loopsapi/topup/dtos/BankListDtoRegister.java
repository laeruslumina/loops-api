package com.loops.loopsapi.topup.dtos;

import com.loops.loopsapi.topup.persistence.entity.BankList;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link BankList} entity
 */
@Data
public class BankListDtoRegister implements Serializable {
    private Long bankListId;
    private Long VAccount;
    private BigDecimal balance;
}