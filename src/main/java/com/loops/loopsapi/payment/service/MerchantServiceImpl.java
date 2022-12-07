package com.loops.loopsapi.payment.service;

import com.loops.loopsapi.payment.persistence.models.Merchant;
import com.loops.loopsapi.payment.persistence.repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService{

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
}
