package com.loops.loopsapi.history.pesistence.repository;

import com.loops.loopsapi.history.pesistence.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface InvoiceRepository extends JpaRepository <Invoice, Long> {

    @Query(value = "SELECT i.invoice_id AS invoiceId, i.base_price AS basePrice, i.created_date AS createdDate, i.discount AS discount, i.merchant_name AS merchantName, i.merchant_top_up_name AS merchantTopUpName, i.total_price AS totalPrice, i.user_id AS userId, \n" +
            "(CASE WHEN i.merchant_name IS null THEN 'Top Up' ELSE 'Payment' END) AS orderType\n" +
            "FROM invoice i WHERE user_id = :userId ", nativeQuery = true)
    List<InvoiceDto> findAllByUserIdNative(@Param("userId") Long userId);
}
