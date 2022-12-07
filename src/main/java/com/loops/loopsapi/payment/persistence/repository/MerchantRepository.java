package com.loops.loopsapi.payment.persistence.repository;

import com.loops.loopsapi.payment.persistence.models.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Long> {
}
