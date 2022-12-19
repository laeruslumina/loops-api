package com.loops.loopsapi.history.service;

import com.loops.loopsapi.history.pesistence.entity.Invoice;
import com.loops.loopsapi.history.pesistence.repository.InvoiceDto;
import com.loops.loopsapi.history.pesistence.repository.InvoiceRepository;
import com.loops.loopsapi.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService{
    private final UserService userService;
    private final InvoiceRepository invoiceRepository;

    private BigDecimal getTotalPrice (InvoiceDtoRegister invoiceDtoRegister){
        return invoiceDtoRegister.getBasePrice()
                .subtract(invoiceDtoRegister.getDiscount());
    }

    private Invoice saveInvoice(InvoiceDtoRegister invoiceDtoRegister){
        Invoice save = invoiceRepository.save(invoiceDtoRegister.toEntity());
        return save;
    }

    @Override
    public InvoiceDtoRegister createInvoice(InvoiceDtoRegister invoiceDtoRegister) {
        BigDecimal totalPrice = getTotalPrice(invoiceDtoRegister);
        invoiceDtoRegister.setTotalPrice(totalPrice);
        invoiceDtoRegister.setCreatedDate(new Date());

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

    @Override
    public List<InvoiceDto> listInvoiceDto(Long userId) {
        return invoiceRepository.findAllByUserIdNative(userId);
    }
}
