package com.loops.loopsapi.topup.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankList {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankListId;

    private String bankName;

    @Id
    private Long virtualAcc;

    private BigDecimal balance;

}
