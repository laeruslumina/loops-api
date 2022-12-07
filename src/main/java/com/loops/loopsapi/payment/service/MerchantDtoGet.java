package com.loops.loopsapi.payment.service;

import com.loops.loopsapi.payment.persistence.models.Merchant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * A DTO for the {@link Merchant} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MerchantDtoGet {
    private String customerName;
    private BigDecimal payAmount;

    static MerchantDtoGet fromUser (Merchant merchant){
        return new MerchantDtoGet(merchant.getCustomerName(), merchant.getPayAmount());
    }
}