package com.wjahatsyed.portfolio.business_invoicing_platform.controller;

import com.itextpdf.text.DocumentException;
import com.wjahatsyed.portfolio.business_invoicing_platform.model.Invoice;
import com.wjahatsyed.portfolio.business_invoicing_platform.service.EmailService;
import com.wjahatsyed.portfolio.business_invoicing_platform.util.PdfGeneratorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/generate")
    public ResponseEntity<byte[]> generateInvoice(@RequestBody Invoice invoice) {
        try {
            byte[] pdf = PdfGeneratorUtil.generateInvoicePdf(invoice);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=invoice.pdf");

            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(org.springframework.http.MediaType.APPLICATION_PDF)
                    .body(pdf);
        } catch (DocumentException | IOException ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/email")
    public ResponseEntity<String> sendInvoiceEmail(
            @RequestParam String to,
            @RequestBody Invoice invoice) {
        try {
            byte[] pdf = PdfGeneratorUtil.generateInvoicePdf(invoice);
            emailService.sendInvoiceEmail(to, "Your Invoice", "Please find the attached invoice.", pdf, "invoice.pdf");

            return ResponseEntity.ok("Email sent successfully");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email sending failed");
        }
    }
}
