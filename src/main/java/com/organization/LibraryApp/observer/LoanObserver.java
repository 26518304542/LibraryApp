package com.organization.LibraryApp.observer;

import com.organization.LibraryApp.model.Loan;

public interface LoanObserver {
    public void onBookBorrowed(Loan loan);
    public void onBookReturned(Loan loan);
}
