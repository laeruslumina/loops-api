package com.loops.loopsapi.payment.service.impl;

import com.loops.loopsapi.payment.dtos.MerchantDtoCheck;
import com.loops.loopsapi.payment.dtos.MerchantDtoGet;
import com.loops.loopsapi.payment.dtos.MerchantDtoRegister;
import com.loops.loopsapi.payment.persistence.models.Merchant;
import com.loops.loopsapi.payment.persistence.repository.MerchantRepository;
import com.loops.loopsapi.payment.service.MerchantService;
import com.loops.loopsapi.utils.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private final MerchantRepository merchantRepository;

    private Merchant saveUser (MerchantDtoRegister merchantDtoRegister){
        return merchantRepository.save(merchantDtoRegister.toEntity());
    }

    @Override
    public MerchantDtoRegister createPayment(MerchantDtoRegister merchantDtoRegister) {
        return MerchantDtoRegister.fromUser(saveUser(merchantDtoRegister));
    }

    @Override
    public MerchantDtoGet getPayment(Long id) {
        return merchantRepository.findById(id)
                .map(MerchantDtoGet::fromUser)
                .orElseThrow(() -> new EntityNotFoundException("Payment Not Found"));
    }

    @Override
    public APIResponse isMerchantExist(MerchantDtoCheck merchantDtoCheck) {
        Merchant merchant = merchantRepository.findByMerchantId(merchantDtoCheck.getMerchantId()).orElse(null);
        APIResponse apiResponse = new APIResponse();
        if (merchant != null ) {
            apiResponse.setValid("Check Success");
            apiResponse.setMerchantId(merchant.getMerchantId());
        } else {
            apiResponse.setValid("Check Failed");
        }
        return apiResponse;
    }
}
