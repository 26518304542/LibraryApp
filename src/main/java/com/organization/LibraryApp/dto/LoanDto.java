package com.organization.LibraryApp.dto;

import com.organization.LibraryApp.loan.model.Loan;

public record LoanDto(Long id, BookDto book, MemberDto member, boolean returned,double feeCharged) {
    public static LoanDto fromEntity(Loan loan) {
        return new LoanDto(
            loan.getId(),
            BookDto.fromEntity(loan.getBook()),
            MemberDto.fromEntity(loan.getMember()),
            loan.isReturned(),
            loan.getFeeCharged()
        );
    }
}



