package com.organization.LibraryApp.strategy;

import com.organization.LibraryApp.model.Loan;

public interface FeeStrategy {

    double calculateFee(Loan loan);
}
