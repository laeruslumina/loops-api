package com.loops.loopsapi.history.service;

import com.loops.loopsapi.history.pesistence.entity.Invoice;
import org.springframework.data.domain.Page;

public interface InvoiceService {

    InvoiceDtoRegister createInvoice (InvoiceDtoRegister invoiceDtoRegister);

    InvoiceDtoRegister findInvoiceById (Long invoiceId);

    Page<Invoice> listOfTransaction();

}
