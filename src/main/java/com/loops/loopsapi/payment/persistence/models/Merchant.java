package com.loops.loopsapi.payment.persistence.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.Valid;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Valid
@Builder
public class Merchant {

    private Long merchantId;

    private String merchantName;

    @Id
    private Long paymentId;

    private String customerName;

    private BigDecimal payAmount;

}
