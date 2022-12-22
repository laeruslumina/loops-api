package com.loops.loopsapi.promo.service;

import com.loops.loopsapi.promo.dtos.PromoDtoRegister;
import com.loops.loopsapi.promo.persistence.entity.Promo;
import com.loops.loopsapi.promo.persistence.repository.PromoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PromoServiceImpl implements PromoService{

    private final PromoRepository promoRepository;

    public Promo savePromo(PromoDtoRegister promoDtoRegister){
        return promoRepository.save(promoDtoRegister.toEntity());
    }

    @Override
    public PromoDtoRegister createPromo(PromoDtoRegister promoDtoRegister) {
        return PromoDtoRegister.fromPromo(savePromo(promoDtoRegister));
    }

    @Override
    public List<Promo> getPromos() {
        return promoRepository.findAll();
    }
}
