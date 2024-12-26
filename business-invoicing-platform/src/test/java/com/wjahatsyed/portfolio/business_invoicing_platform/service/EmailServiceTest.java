package com.wjahatsyed.portfolio.business_invoicing_platform.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.javamail.JavaMailSender;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmailServiceTest {

    @Mock
    private JavaMailSender mailSender;

    @InjectMocks
    private EmailService emailService;

    private MimeMessage mimeMessage;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mimeMessage = mock(MimeMessage.class);
        when(mailSender.createMimeMessage()).thenReturn(mimeMessage);
    }

    @Test
    void testSendInvoiceEmailSuccess() throws Exception {
        String to = "test@example.com";
        String subject = "Invoice Subject";
        String body = "This is the email body.";
        byte[] attachment = "Sample Data".getBytes();
        String attachmentName = "invoice.pdf";

        emailService.sendInvoiceEmail(to, subject, body, attachment, attachmentName);

        verify(mailSender, times(1)).send(mimeMessage);
    }

    @Test
    void testSendInvoiceEmailFailure() {
        doThrow(new RuntimeException("Mail system down")).when(mailSender).send(any(MimeMessage.class));

        String to = "test@example.com";
        String subject = "Invoice Subject";
        String body = "This is the email body.";
        byte[] attachment = "Sample Data".getBytes();
        String attachmentName = "invoice.pdf";

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            emailService.sendInvoiceEmail(to, subject, body, attachment, attachmentName);
        });

        assertEquals("Email sending failed", exception.getMessage());
    }
}
