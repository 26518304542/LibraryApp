package com.organization.LibraryApp.common.observer;

import java.util.ArrayList;
import java.util.List;

import com.organization.LibraryApp.loan.model.Loan;

public class LoanEventManager implements LoanPublisher {

    private final List<LoanObserver> observers = new ArrayList<>();

    @Override
    public void addObserver(LoanObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(LoanObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyBookBorrowed(Loan loan) {
        for(LoanObserver observer: observers){
            observer.onBookBorrowed(loan);
        }
    }

    @Override
    public void notifyBookReturned(Loan loan) {
        for(LoanObserver observer: observers){
            observer.onBookReturned(loan);
        }
    }



}
