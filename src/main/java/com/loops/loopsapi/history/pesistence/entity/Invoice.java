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
    private Long invoiceId; //ditampilkan x
    private Long userId;
    private Long merchantTopUpId;
    private Long merchantId; //ditampilkan x
    private BigDecimal basePrice; //ditampilkan -
    private BigDecimal discount; //ditampilkan -
    private BigDecimal totalPrice; //ditampilkan x
    private Date createdDate; //ditampilkan x

}
