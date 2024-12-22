package com.wjahatsyed.portfolio.business_invoicing_platform.util;

import com.itextpdf.text.pdf.PdfPTable;
import com.wjahatsyed.portfolio.business_invoicing_platform.model.Invoice;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PdfGeneratorUtil {

    private static final Logger logger = LoggerFactory.getLogger(PdfGeneratorUtil.class);

    public static byte[] generateInvoicePdf(Invoice invoice) throws DocumentException, IOException {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
            Paragraph title = new Paragraph("Invoice", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph("Invoice ID: " + invoice.getId()));
            document.add(new Paragraph("Customer ID: " + invoice.getCustomerId()));
            document.add(new Paragraph("Amount: " + invoice.getAmount()));

            PdfPTable table = new PdfPTable(2);
            table.addCell("Field");
            table.addCell("Value");
            table.addCell("Invoice ID");
            table.addCell(String.valueOf(invoice.getId()));
            table.addCell("Customer ID");
            table.addCell(invoice.getCustomerId());
            table.addCell("Amount");
            table.addCell(invoice.getAmount().toString());

            document.add(table);
            document.close();
        } catch (DocumentException ex) {
            logger.error("Error occurred during PDF generation", ex);
            throw ex;
        }

        return out.toByteArray();
    }
}
