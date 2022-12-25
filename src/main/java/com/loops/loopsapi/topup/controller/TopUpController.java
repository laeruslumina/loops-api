package com.loops.loopsapi.topup.controller;

import com.loops.loopsapi.topup.dtos.BankListDtoRegister;
import com.loops.loopsapi.topup.persistence.entity.BankListDtoCheck;
import com.loops.loopsapi.topup.service.BankListService;
import com.loops.loopsapi.utils.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/topup")
public class TopUpController {

    @Autowired
    private final BankListService bankListService;

    @PostMapping("/create")
    BankListDtoRegister createData (@RequestBody BankListDtoRegister bankListDtoRegister){
        return bankListService.createBank(bankListDtoRegister);
    }

    @PostMapping("/find")
    APIResponse checkBank (@RequestBody BankListDtoCheck bankListDtoCheck){
        return bankListService.isBankExist(bankListDtoCheck);
    }

    @GetMapping("/get/{virtualAcc}")
    BankListDtoRegister getBank (@PathVariable Long virtualAcc){
        return bankListService.getBank(virtualAcc);
    }
}
