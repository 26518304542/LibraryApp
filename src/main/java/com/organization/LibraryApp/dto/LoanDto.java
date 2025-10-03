package com.organization.LibraryApp.dto;

import com.organization.LibraryApp.model.Loan;

public record LoanDto(Long id, String bookTitle, String memberName, boolean returned) {
    public static LoanDto fromEntity(Loan loan) {
        return new LoanDto(
            loan.getId(),
            loan.getBook().getTitle(),
            loan.getMember().getName(),
            loan.isReturned()
        );
    }
}



