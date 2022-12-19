package com.loops.loopsapi.history.pesistence.entity;

import com.loops.loopsapi.user.persistence.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

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
    private String merchantTopUpName;
    private String merchantName; //ditampilkan x
    private BigDecimal basePrice; //ditampilkan -
    private BigDecimal discount; //ditampilkan -
    private BigDecimal totalPrice; //ditampilkan x
    @CreatedDate
    private Date createdDate; //ditampilkan x

    //    @ManyToOne
//    private User user;


}
