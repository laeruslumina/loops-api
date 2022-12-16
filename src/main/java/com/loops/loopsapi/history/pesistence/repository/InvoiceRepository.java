package com.loops.loopsapi.history.pesistence.repository;

import com.loops.loopsapi.history.pesistence.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository <Invoice, Long> {



}
