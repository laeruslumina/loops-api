package com.loops.loopsapi.payment.dtos;

import com.loops.loopsapi.payment.persistence.models.Merchant;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Merchant} entity
 */
@Data
public class MerchantDtoCheck {
    private final Long merchantId;
}