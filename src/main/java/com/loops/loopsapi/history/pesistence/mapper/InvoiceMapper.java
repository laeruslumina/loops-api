package com.loops.loopsapi.history.pesistence.mapper;

import java.math.BigDecimal;
import java.util.Date;

public interface InvoiceMapper {

    Long getInvoiceId();
    BigDecimal getBasePrice();
    Date getCreatedDate();
    BigDecimal getDiscount();
    String getMerchantName();
    Long getMerchantId();
    String getMerchantTopUpName();
    String getOrderType();
    BigDecimal getTotalPrice();
    Long getUserId();

}
