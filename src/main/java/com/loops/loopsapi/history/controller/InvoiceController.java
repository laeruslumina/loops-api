package com.loops.loopsapi.history.controller;

import com.loops.loopsapi.history.pesistence.entity.Invoice;
import com.loops.loopsapi.history.pesistence.mapper.InvoiceMapper;
import com.loops.loopsapi.history.dtos.InvoiceDtoRegister;
import com.loops.loopsapi.history.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping("/create")
    InvoiceMapper createData (@RequestBody InvoiceDtoRegister invoiceDtoRegister){
        return invoiceService.createInvoice(invoiceDtoRegister);
    }

    @GetMapping("/find/{id}")
    InvoiceDtoRegister findData (@PathVariable Long id){
        return invoiceService.findInvoiceById(id);
    }

    @GetMapping("/find")
    Page <Invoice> history(){
        return invoiceService.listOfTransaction();
    }

    @GetMapping("/userinvoice/{id}")
    List<InvoiceMapper> listInvoice (@PathVariable Long id){
        return invoiceService.listInvoiceDto(id);
    }

}
