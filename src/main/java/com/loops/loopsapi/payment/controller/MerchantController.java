package com.loops.loopsapi.payment.controller;

import com.loops.loopsapi.payment.dtos.MerchantDtoCheck;
import com.loops.loopsapi.payment.dtos.MerchantDtoGet;
import com.loops.loopsapi.payment.dtos.MerchantDtoRegister;
import com.loops.loopsapi.payment.service.MerchantService;
import com.loops.loopsapi.utils.APIResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/merchant")
public class MerchantController {

    private final MerchantService merchantService;

    @PostMapping("/create")
    MerchantDtoRegister createDataPayment (@RequestBody MerchantDtoRegister merchantDtoRegister){
        return merchantService.createPayment(merchantDtoRegister);
    }

    @GetMapping("/payment/{id}")
    MerchantDtoGet merchantDtoGet (@PathVariable Long id){
        return merchantService.getPayment(id);
    }

    @PostMapping ("/find")
    APIResponse merchantDtoCheck (@RequestBody MerchantDtoCheck merchantDtoCheck){
        return merchantService.isMerchantExist(merchantDtoCheck);
    }

}
