package com.organization.LibraryApp.common.observer;

import com.organization.LibraryApp.loan.model.Loan;

public interface LoanObserver {
    public void onBookBorrowed(Loan loan);
    public void onBookReturned(Loan loan);
}
