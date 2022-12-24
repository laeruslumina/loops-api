package com.loops.loopsapi.payment.service;

import com.loops.loopsapi.payment.dtos.MerchantDtoCheck;
import com.loops.loopsapi.payment.dtos.MerchantDtoGet;
import com.loops.loopsapi.payment.dtos.MerchantDtoRegister;
import com.loops.loopsapi.utils.APIResponse;

public interface MerchantService {

    MerchantDtoRegister createPayment(MerchantDtoRegister merchantDtoRegister);

    MerchantDtoGet getPayment(Long id);

    APIResponse isMerchantExist(MerchantDtoCheck merchantDtoCheck);

}
