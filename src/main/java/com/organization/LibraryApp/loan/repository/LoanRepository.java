package com.organization.LibraryApp.loan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.organization.LibraryApp.loan.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
    List<Loan> findByMember_IdAndReturnedFalse(Long memberId);
    List<Loan> findByBook_IdAndReturnedFalse(Long bookId);
}
