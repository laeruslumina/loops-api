package com.loops.loopsapi.topup.service;

import java.math.BigDecimal;

public interface TopUpService {

    void addBalance (Long id,BigDecimal input);

    void decreaseBalance (Long id, BigDecimal input);

}
