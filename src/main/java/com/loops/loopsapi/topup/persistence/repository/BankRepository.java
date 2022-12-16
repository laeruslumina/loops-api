package com.loops.loopsapi.topup.persistence.repository;

import com.loops.loopsapi.topup.persistence.entity.BankList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<BankList, Long> {
}
