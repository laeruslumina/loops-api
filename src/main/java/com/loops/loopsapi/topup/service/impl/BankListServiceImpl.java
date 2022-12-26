package com.loops.loopsapi.topup.service.impl;

import com.loops.loopsapi.topup.dtos.BankListDtoRegister;
import com.loops.loopsapi.topup.persistence.entity.BankList;
import com.loops.loopsapi.topup.dtos.BankListDtoCheck;
import com.loops.loopsapi.topup.persistence.repository.BankListRepository;
import com.loops.loopsapi.topup.service.BankListService;
import com.loops.loopsapi.utils.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class BankListServiceImpl implements BankListService {

    @Autowired
    private final BankListRepository bankListRepository;

    public BankList saveBank(BankListDtoRegister bankListDtoRegister){
        return bankListRepository.save(bankListDtoRegister.toEntity());
    }

    @Override
    public BankListDtoRegister createBank(BankListDtoRegister bankListDtoRegister) {
        return BankListDtoRegister.fromBank(saveBank(bankListDtoRegister));
    }

    @Override
    public APIResponse isBankExist(BankListDtoCheck bankListDtoCheck) {
        BankList bankList = bankListRepository.findByVirtualAcc(bankListDtoCheck.getVirtualAcc()).orElse(null);
        APIResponse apiResponse = new APIResponse();
        if (bankList != null ) {
            apiResponse.setValid("Check Success");
            apiResponse.setVirtualAcc(bankList.getVirtualAcc());
        } else {
            apiResponse.setValid("Check Failed");
        }
        return apiResponse;
    }

    @Override
    public BankListDtoRegister getBank(Long vAccount) {
        return bankListRepository.findById(vAccount)
                .map(BankListDtoRegister::fromBank)
                .orElseThrow(() -> new EntityNotFoundException("Payment Not Found"));
    }
}
