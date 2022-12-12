package com.loops.loopsapi.history.controller;

import com.loops.loopsapi.history.pesistence.entity.Invoice;
import com.loops.loopsapi.history.service.InvoiceDtoRegister;
import com.loops.loopsapi.history.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/invoice")
public class InvoiceController {

    private final InvoiceService invoiceService;

    @PostMapping("/create")
    InvoiceDtoRegister createData (@RequestBody InvoiceDtoRegister invoiceDtoRegister){
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

}
