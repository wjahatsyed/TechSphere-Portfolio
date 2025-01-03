package com.wjahatsyed.portfolio.business_invoicing_platform.util;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import com.wjahatsyed.portfolio.business_invoicing_platform.model.Invoice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigDecimal;

public class PdfGeneratorUtilTest {

    @Test
    public void testGenerateInvoicePdf() {
        // Arrange
        Invoice testInvoice = new Invoice();
        testInvoice.setCustomerId("CUST001");
        testInvoice.setAmount(BigDecimal.valueOf(2500.75));

        // Act
        byte[] pdfBytes;
        try {
            pdfBytes = PdfGeneratorUtil.generateInvoicePdf(testInvoice);

            // Assert
            PdfReader pdfReader = new PdfReader(pdfBytes);
            String pageContent = PdfTextExtractor.getTextFromPage(pdfReader, 1);

            // Check the content of the PDF
            Assertions.assertTrue(pageContent.contains("Invoice"), "PDF should contain the title 'Invoice'");
            Assertions.assertTrue(pageContent.contains("Customer ID: CUST001"), "PDF should contain the Customer ID");
            Assertions.assertTrue(pageContent.contains("Amount: 2500.75"), "PDF should contain the Amount");

            // Optionally check that Invoice ID exists
            Assertions.assertTrue(pageContent.contains("Invoice ID: "), "PDF should contain an autogenerated Invoice ID");

            pdfReader.close();
        } catch (Exception e) {
            Assertions.fail("Exception occurred while generating or reading the PDF: " + e.getMessage());
        }
    }
}
