package com.organization.LibraryApp.common.strategy;

import com.organization.LibraryApp.loan.model.Loan;

public interface FeeStrategy {

    double calculateFee(Loan loan);
}
