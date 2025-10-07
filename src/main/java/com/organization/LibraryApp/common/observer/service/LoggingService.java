package com.organization.LibraryApp.common.observer.service;

import org.springframework.stereotype.Service;

import com.organization.LibraryApp.common.observer.LoanObserver;
import com.organization.LibraryApp.loan.model.Loan;

@Service
public class LoggingService implements LoanObserver{

    @Override
    public void onBookBorrowed(Loan loan){
        System.out.println("Loan created: " + loan.getBook().getId() + " title: " + loan.getBook().getTitle());
    }

    @Override
    public void onBookReturned(Loan loan){
        System.out.println("Loan returned: " + loan.getBook().getId() + " title: " + loan.getBook().getTitle());
    }

}
