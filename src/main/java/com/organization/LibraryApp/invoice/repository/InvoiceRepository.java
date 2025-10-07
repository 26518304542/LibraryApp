package com.organization.LibraryApp.invoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.LibraryApp.invoice.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
