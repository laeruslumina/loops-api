package com.loops.loopsapi.history.service.impl;

import com.loops.loopsapi.history.dtos.InvoiceDtoRegister;
import com.loops.loopsapi.history.pesistence.entity.Invoice;
import com.loops.loopsapi.history.pesistence.mapper.InvoiceMapper;
import com.loops.loopsapi.history.pesistence.repository.InvoiceRepository;
import com.loops.loopsapi.history.service.InvoiceService;
import com.loops.loopsapi.topup.service.TopUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;

    private final TopUpService topUpService;

    private Invoice saveInvoice(InvoiceDtoRegister invoiceDtoRegister){
        return invoiceRepository.save(invoiceDtoRegister.toEntity());
    }

    @Override
    public InvoiceMapper createInvoice(InvoiceDtoRegister invoiceDtoRegister) {
        invoiceDtoRegister.setCreatedDate(new Date());
        if (invoiceDtoRegister.getMerchantId() != null){
            topUpService.decreaseBalance(invoiceDtoRegister.getUserId(), invoiceDtoRegister.getTotalPrice());
        } else {
            topUpService.addBalance(invoiceDtoRegister.getUserId(), invoiceDtoRegister.getTotalPrice());
        }
        InvoiceDtoRegister output = InvoiceDtoRegister.fromInvoice(saveInvoice(invoiceDtoRegister));
        return invoiceRepository.findByInvoiceIdNative(output.getInvoiceId());
    }

    @Override
    public InvoiceDtoRegister findInvoiceById(Long invoiceId) {
        return invoiceRepository.findById(invoiceId)
                .map(InvoiceDtoRegister::fromInvoice)
                .orElseThrow(() -> new EntityNotFoundException("Payment Not Found"));
    }

    @Override
    public Page<Invoice> listOfTransaction() {
        return invoiceRepository.findAll(PageRequest.of(0,5, Sort.by(Sort.Direction.DESC, "orderId")));
    }

    @Override
    public List<InvoiceMapper> listInvoiceDto(Long userId) {
        return invoiceRepository.findAllByUserIdNative(userId);
    }
}
