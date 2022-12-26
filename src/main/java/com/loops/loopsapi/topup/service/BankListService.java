package com.loops.loopsapi.topup.service;

import com.loops.loopsapi.topup.dtos.BankListDtoRegister;
import com.loops.loopsapi.topup.dtos.BankListDtoCheck;
import com.loops.loopsapi.utils.APIResponse;

public interface BankListService {

    BankListDtoRegister createBank (BankListDtoRegister bankListDtoRegister);

    APIResponse isBankExist (BankListDtoCheck bankListDtoCheck);

    BankListDtoRegister getBank (Long VAccount);

}
