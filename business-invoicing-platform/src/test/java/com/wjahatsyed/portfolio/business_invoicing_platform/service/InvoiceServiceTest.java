package com.wjahatsyed.portfolio.business_invoicing_platform.service;

import com.wjahatsyed.portfolio.business_invoicing_platform.model.Invoice;
import com.wjahatsyed.portfolio.business_invoicing_platform.repository.InvoiceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class InvoiceServiceTest {

    @Mock
    private InvoiceRepository invoiceRepository;

    @InjectMocks
    private InvoiceService invoiceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetInvoiceByIdSuccess() {
        // Create a mock invoice
        Invoice mockInvoice = new Invoice();
        mockInvoice.setCustomerId("C123");
        mockInvoice.setAmount(new BigDecimal("150.75"));
        mockInvoice.setPdfPath("/invoices/invoice1.pdf");

        // Simulate repository behavior
        when(invoiceRepository.findById(1L)).thenReturn(Optional.of(mockInvoice));

        // Call the service method
        Invoice invoice = invoiceService.getInvoiceById(1L);

        // Verify the result
        assertNotNull(invoice);
        assertEquals("C123", invoice.getCustomerId());
        assertEquals(new BigDecimal("150.75"), invoice.getAmount());
        assertEquals("/invoices/invoice1.pdf", invoice.getPdfPath());
    }

    @Test
    void testGetInvoiceByIdNotFound() {
        // Simulate repository behavior for a non-existing ID
        when(invoiceRepository.findById(2L)).thenReturn(Optional.empty());

        // Verify the exception is thrown
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            invoiceService.getInvoiceById(2L);
        });

        assertEquals("Invoice not found", exception.getMessage());
    }
}
