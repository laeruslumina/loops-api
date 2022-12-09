package com.loops.loopsapi.promo.service;

import com.loops.loopsapi.promo.persistence.entity.Promo;

import java.util.List;

public interface PromoService {

    List<Promo> getPromos();

    PromoDtoRegister createPromo(PromoDtoRegister promoDtoRegister);

}
