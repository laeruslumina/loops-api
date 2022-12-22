package com.loops.loopsapi.payment.dtos;

import com.loops.loopsapi.payment.persistence.models.Merchant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link Merchant} entity
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MerchantDtoRegister implements Serializable {

    private static final long serialVersionUID = -5016611933815335309L;

    @NotNull
    private Long merchantId;

    @NotEmpty
    private String merchantName;

    @NotNull
    private Long paymentId;

    @NotEmpty
    private String customerName;

    @Column(columnDefinition = "decimal(19,2)")
    private BigDecimal payAmount;

    public static MerchantDtoRegister fromUser(Merchant merchant){
        return new MerchantDtoRegister(merchant.getMerchantId(), merchant.getMerchantName(), merchant.getPaymentId(), merchant.getCustomerName(), merchant.getPayAmount());
    }

    public Merchant toEntity(){
        return Merchant.builder()
                .merchantId(merchantId)
                .merchantName(merchantName)
                .paymentId(paymentId)
                .customerName(customerName)
                .payAmount(payAmount)
                .build();
    }

}