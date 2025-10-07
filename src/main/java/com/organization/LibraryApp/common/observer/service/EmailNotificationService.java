package com.organization.LibraryApp.common.observer.service;

import org.springframework.stereotype.Service;

import com.organization.LibraryApp.common.observer.LoanObserver;
import com.organization.LibraryApp.loan.model.Loan;

@Service
public class EmailNotificationService implements LoanObserver{

    @Override
    public void onBookBorrowed(Loan loan){
        System.out.println("Email " + loan.getMember().getEmail() + "-" + loan.getBook().getTitle());
    }

    @Override
    public void onBookReturned(Loan loan){
        System.out.println("Email " +loan.getMember().getEmail() + "-" + loan.getBook().getTitle());
    }

}
