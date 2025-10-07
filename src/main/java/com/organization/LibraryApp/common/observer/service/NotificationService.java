package com.organization.LibraryApp.common.observer.service;

import org.springframework.stereotype.Service;

import com.organization.LibraryApp.common.observer.LoanObserver;
import com.organization.LibraryApp.loan.model.Loan;

@Service
public class NotificationService implements LoanObserver{

    @Override
    public void onBookBorrowed(Loan loan){
        System.out.println("Book borrowed: " + loan.getBook().getTitle());
    }

    @Override
    public void onBookReturned(Loan loan){
        System.out.println("Book returned: " + loan.getBook().getTitle());
    }
}
