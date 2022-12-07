package com.loops.loopsapi.payment.service;

public interface MerchantService {

    MerchantDtoRegister createPayment(MerchantDtoRegister merchantDtoRegister);

    MerchantDtoGet getPayment(Long id);

}
