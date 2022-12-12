package com.loops.loopsapi.history.service;

import com.loops.loopsapi.history.pesistence.entity.Invoice;
import com.loops.loopsapi.history.pesistence.repository.InvoiceRepository;
import com.loops.loopsapi.payment.service.MerchantDtoGet;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService{


    private final InvoiceRepository invoiceRepository;

    private BigDecimal getTotalPrice (InvoiceDtoRegister invoiceDtoRegister){
        return invoiceDtoRegister.getBasePrice()
                .subtract(invoiceDtoRegister.getDiscount());
    }

    private Invoice saveInvoice(InvoiceDtoRegister invoiceDtoRegister){
        return invoiceRepository.save(invoiceDtoRegister.toEntity());
    }

    @Override
    public InvoiceDtoRegister createInvoice(InvoiceDtoRegister invoiceDtoRegister) {
        BigDecimal totalPrice = getTotalPrice(invoiceDtoRegister);
        invoiceDtoRegister.setTotalPrice(totalPrice);

        return InvoiceDtoRegister.fromInvoice(saveInvoice(invoiceDtoRegister));
    }

    @Override
    public InvoiceDtoRegister findInvoiceById(Long invoiceId) {
        return invoiceRepository.findById(invoiceId)
                .map(InvoiceDtoRegister::fromInvoice)
                .orElseThrow(() -> new EntityNotFoundException("Payment Not Found"));
    }

    @Override
    public Page<Invoice> listOfTransaction() {
        return (Page<Invoice>) invoiceRepository.findAll(PageRequest.of(0,5, Sort.by(Sort.Direction.DESC, "orderId")));
    }
}
