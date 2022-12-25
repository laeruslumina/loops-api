package com.loops.loopsapi.topup.persistence.repository;

import com.loops.loopsapi.topup.persistence.entity.BankList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankListRepository extends JpaRepository<BankList, Long> {
    Optional<BankList> findByVAccount(Long VAccount);
}
