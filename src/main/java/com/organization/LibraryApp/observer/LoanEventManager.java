package com.organization.LibraryApp.observer;

import com.organization.LibraryApp.model.Loan;

public class LoanEventManager implements LoanPublisher {

    @Override
    public void addObserver(LoanObserver observer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addObserver'");
    }

    @Override
    public void removeObserver(LoanObserver observer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeObserver'");
    }

    @Override
    public void notifyBookBorrowed(Loan loan) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notifyBookBorrowed'");
    }

    @Override
    public void notifyBookReturned(Loan loan) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'notifyBookReturned'");
    }



}
