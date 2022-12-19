package com.loops.loopsapi.history.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.loops.loopsapi.history.pesistence.entity.Invoice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * A DTO for the {@link Invoice} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceDtoRegister implements Serializable {

    private static final long serialVersionUID = -4340825865170044520L;

    private Long invoiceId;
    private Long userId; //dari FE kirim user ID
    private String merchantTopUpName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String merchantName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal basePrice;
    private BigDecimal discount;
    private BigDecimal totalPrice;
    private Date createdDate;

    static InvoiceDtoRegister fromInvoice (Invoice invoice){
        return new InvoiceDtoRegister(invoice.getInvoiceId(), invoice.getUserId(),
         invoice.getMerchantTopUpName(),invoice.getMerchantName(), invoice.getBasePrice(), invoice.getDiscount(), invoice.getTotalPrice()
        , invoice.getCreatedDate());
    }

    Invoice toEntity(){
        return Invoice.builder()
                .invoiceId(invoiceId)
                .userId(userId)
                .merchantTopUpName(merchantTopUpName)
                .merchantName(merchantName)
                .basePrice(basePrice)
                .discount(discount)
                .totalPrice(totalPrice)
                .createdDate(createdDate)
                .build();
    }
}