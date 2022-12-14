package com.loops.loopsapi.history.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.loops.loopsapi.history.pesistence.entity.Invoice;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
public class InvoiceDtoRegister {

    private Long invoiceId;
    private Long userId; //dari FE kirim user ID
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long virtualAcc;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long merchantId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal basePrice;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal discount;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BigDecimal totalPrice;
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    public static InvoiceDtoRegister fromInvoice(Invoice invoice){
        return new InvoiceDtoRegister(invoice.getInvoiceId(), invoice.getUserId(),
         invoice.getVirtualAcc(),invoice.getMerchantId(), invoice.getBasePrice(), invoice.getDiscount(), invoice.getTotalPrice()
        , invoice.getCreatedDate());
    }

    public Invoice toEntity(){
        return Invoice.builder()
                .invoiceId(invoiceId)
                .userId(userId)
                .virtualAcc(virtualAcc)
                .merchantId(merchantId)
                .basePrice(basePrice)
                .discount(discount)
                .totalPrice(totalPrice)
                .createdDate(createdDate)
                .build();
    }
}