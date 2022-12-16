package com.loops.loopsapi.topup.controller;

import com.loops.loopsapi.topup.service.TopUpDto;
import com.loops.loopsapi.topup.service.TopUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class TopUpController {

    private final TopUpService topUpService;

    @PutMapping("/add/{id}")
    public String topUpBalance(@PathVariable Long id, @RequestBody TopUpDto topUpDto){
        return topUpService.addBalance(id, topUpDto);
    }

    @PutMapping("/substract")
    public String substractBalance (Long id, @RequestBody TopUpDto topUpDto){ //Lebih efisien id dimasukan DTO
        return topUpService.decreaseBalance(id, topUpDto);
    }

}
