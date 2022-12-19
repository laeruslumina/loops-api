package com.loops.loopsapi.topup.persistence.repository;

import com.loops.loopsapi.topup.persistence.entity.MerchantTopUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantTopUpRepository extends JpaRepository<MerchantTopUp, Long> {
}
