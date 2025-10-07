package com.organization.LibraryApp.common.strategy;

import com.organization.LibraryApp.loan.model.Loan;

public class FixedFeeStrategy implements FeeStrategy{

    private static double fixedFee;

    public FixedFeeStrategy(double fixedFee) {
        this.fixedFee = fixedFee;
    }

    @Override
    public double calculateFee(Loan loan) {
        return fixedFee;
    }
}
