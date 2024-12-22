package com.wjahatsyed.portfolio.business_invoicing_platform.repository;

import com.wjahatsyed.portfolio.business_invoicing_platform.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
