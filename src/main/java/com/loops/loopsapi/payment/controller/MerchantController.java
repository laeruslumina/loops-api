package com.loops.loopsapi.payment.controller;

import com.loops.loopsapi.payment.service.MerchantDtoGet;
import com.loops.loopsapi.payment.service.MerchantDtoRegister;
import com.loops.loopsapi.payment.service.MerchantService;
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

}
