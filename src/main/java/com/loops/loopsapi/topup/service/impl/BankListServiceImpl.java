package com.loops.loopsapi.topup.service.impl;

import com.loops.loopsapi.payment.dtos.MerchantDtoCheck;
import com.loops.loopsapi.payment.dtos.MerchantDtoGet;
import com.loops.loopsapi.topup.dtos.BankListDtoRegister;
import com.loops.loopsapi.topup.persistence.entity.BankList;
import com.loops.loopsapi.topup.persistence.entity.BankListDtoCheck;
import com.loops.loopsapi.topup.persistence.repository.BankListRepository;
import com.loops.loopsapi.topup.service.BankListService;
import com.loops.loopsapi.utils.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class BankListServiceImpl implements BankListService {

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
        BankList bankList = bankListRepository.findByVAccount(bankListDtoCheck.getVAccount()).orElse(null);
        APIResponse apiResponse = new APIResponse();
        if (bankList != null ) {
            apiResponse.setValid("Check Success");
            apiResponse.setMerchantId(bankList.getVAccount());
        } else {
            apiResponse.setValid("Check Failed");
        }
        return apiResponse;
    }

    @Override
    public BankListDtoRegister getBank(Long VAccount) {
        return bankListRepository.findById(VAccount)
                .map(BankListDtoRegister::fromBank)
                .orElseThrow(() -> new EntityNotFoundException("Payment Not Found"));
    }
}
