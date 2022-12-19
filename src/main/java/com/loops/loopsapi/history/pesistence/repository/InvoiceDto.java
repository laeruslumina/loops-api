package com.loops.loopsapi.history.pesistence.repository;

import java.math.BigDecimal;
import java.util.Date;

public interface InvoiceDto {

    Long getInvoiceId();
    BigDecimal getBasePrice();
    Date getCreatedDate();
    BigDecimal getDiscount();
    String getMerchantName();
    String getMerchantTopUpName();
    String getOrderType();
    BigDecimal getTotalPrice();
    Long getUserId();

}
