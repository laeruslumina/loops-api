package com.loops.loopsapi.promo.persistence.repository;

import com.loops.loopsapi.promo.persistence.entity.Promo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PromoRepository extends JpaRepository<Promo, Long> {
}
