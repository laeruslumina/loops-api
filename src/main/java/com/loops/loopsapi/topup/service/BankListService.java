package com.loops.loopsapi.topup.service;

import com.loops.loopsapi.payment.dtos.MerchantDtoCheck;
import com.loops.loopsapi.topup.dtos.BankListDtoRegister;
import com.loops.loopsapi.topup.persistence.entity.BankListDtoCheck;
import com.loops.loopsapi.utils.APIResponse;

public interface BankListService {

    BankListDtoRegister createBank (BankListDtoRegister bankListDtoRegister);

    APIResponse isBankExist (BankListDtoCheck bankListDtoCheck);

    BankListDtoRegister getBank (Long VAccount);

}
