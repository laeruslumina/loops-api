package com.loops.loopsapi.history.pesistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long invoiceId;
    private Long userId;
    private Long virtualAcc;
    private Long merchantId;
    private BigDecimal basePrice;
    private BigDecimal discount;
    private BigDecimal totalPrice;
    private Date createdDate;

}
