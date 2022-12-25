package com.loops.loopsapi.history.pesistence.repository;

import com.loops.loopsapi.history.pesistence.entity.Invoice;
import com.loops.loopsapi.history.pesistence.mapper.InvoiceMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface InvoiceRepository extends JpaRepository <Invoice, Long> {

    @Query(value = "SELECT i.invoice_id AS invoiceId, i.base_price AS basePrice, " +
            " i.created_date AS createdDate, i.discount AS discount, i.total_price AS totalPrice, " +
            " i.user_id AS userId, (CASE WHEN i.merchant_id IS null THEN 'Top Up' ELSE 'Payment' END) AS orderType, " +
            " i.merchant_id AS merchantId, i.merchant_top_up_id AS merchantTopUpId, m.merchant_name AS merchantName, mt.merchant_top_up_name AS merchantTopUpName " +
            " FROM invoice i LEFT JOIN merchant m ON m.merchant_id = i.merchant_id LEFT JOIN merchant_top_up mt ON mt.merchant_top_up_id = i.merchant_top_up_id " +
            " WHERE user_id = :userId ORDER BY invoiceId DESC LIMIT 5", nativeQuery = true)
    List<InvoiceMapper> findAllByUserIdNative(@Param("userId") Long userId);

    @Query(value = "SELECT i.invoice_id AS invoiceId, i.base_price AS basePrice, " +
            " i.created_date AS createdDate, i.discount AS discount, i.total_price AS totalPrice, " +
            " i.user_id AS userId, (CASE WHEN i.merchant_id IS null THEN 'Top Up' ELSE 'Payment' END) AS orderType, " +
            " i.merchant_id AS merchantId, i.virtual_acc AS virtualAcc, m.merchant_name AS merchantName, bl.bank_name AS bankName " +
            " FROM invoice i LEFT JOIN merchant m ON m.merchant_id = i.merchant_id LEFT JOIN bank_list bl ON bl.virtual_acc = i.virtual_acc " +
            " WHERE invoice_id = :invoiceId", nativeQuery = true)
    InvoiceMapper findByInvoiceIdNative(@Param("invoiceId") Long invoiceId);

}
