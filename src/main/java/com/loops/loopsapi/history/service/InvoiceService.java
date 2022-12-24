package com.loops.loopsapi.history.service;

import com.loops.loopsapi.history.dtos.InvoiceDtoRegister;
import com.loops.loopsapi.history.pesistence.entity.Invoice;
import com.loops.loopsapi.history.pesistence.repository.InvoiceDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InvoiceService {

    InvoiceDto createInvoice (InvoiceDtoRegister invoiceDtoRegister);

    InvoiceDtoRegister findInvoiceById (Long invoiceId);

    Page<Invoice> listOfTransaction();

    List<InvoiceDto> listInvoiceDto(Long userId);

}
