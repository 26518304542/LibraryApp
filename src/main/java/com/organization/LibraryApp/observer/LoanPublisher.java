package com.organization.LibraryApp.observer;

import com.organization.LibraryApp.model.Loan;

public interface LoanPublisher {
    public void addObserver(LoanObserver observer);
    public void removeObserver(LoanObserver observer);
    public void notifyBookBorrowed(Loan loan);
    public void notifyBookReturned(Loan loan);

}
