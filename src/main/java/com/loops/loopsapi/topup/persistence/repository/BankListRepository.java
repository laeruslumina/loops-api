package com.loops.loopsapi.topup.persistence.repository;

import com.loops.loopsapi.topup.persistence.entity.BankList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankListRepository extends JpaRepository<BankList, Long> {
}
