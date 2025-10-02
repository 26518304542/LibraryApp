package com.organization.LibraryApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.LibraryApp.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
