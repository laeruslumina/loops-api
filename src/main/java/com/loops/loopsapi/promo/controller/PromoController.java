package com.loops.loopsapi.promo.controller;

import com.loops.loopsapi.promo.service.PromoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PromoController {

    private final PromoService promoService;



}
