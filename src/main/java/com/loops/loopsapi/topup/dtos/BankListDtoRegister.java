package com.loops.loopsapi.topup.dtos;

import com.loops.loopsapi.topup.persistence.entity.BankList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link BankList} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankListDtoRegister {
    private Long bankListId;
    private String bankName;
    private Long VAccount;
    private BigDecimal balance;

    public static BankListDtoRegister fromBank(BankList bankList){
        return new BankListDtoRegister(bankList.getBankListId(), bankList.getBankName(), bankList.getVAccount(), bankList.getBalance());
    }

    public BankList toEntity(){
        return BankList.builder()
                .bankListId(bankListId)
                .bankName(bankName)
                .VAccount(VAccount)
                .balance(balance)
                .build();
    }

}