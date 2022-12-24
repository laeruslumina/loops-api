package com.loops.loopsapi.promo.dtos;

import com.loops.loopsapi.promo.persistence.entity.Promo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link Promo} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PromoDtoRegister {
    private Long promoId;
    private String promoName;
    private String promoDetails;

    public static PromoDtoRegister fromPromo(Promo promo){
        return new PromoDtoRegister(promo.getPromoId(), promo.getPromoName(), promo.getPromoDetails());
    }

    public Promo toEntity(){
        return Promo.builder()
                .promoId(promoId)
                .promoName(promoName)
                .promoDetails(promoDetails)
                .build();
    }

}