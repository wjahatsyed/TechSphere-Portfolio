package com.wjahatsyed.portfolio.business_invoicing_platform.service;

import com.wjahatsyed.portfolio.business_invoicing_platform.model.Invoice;
import com.wjahatsyed.portfolio.business_invoicing_platform.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(id).orElseThrow(() -> new RuntimeException("Invoice not found"));
    }
}
