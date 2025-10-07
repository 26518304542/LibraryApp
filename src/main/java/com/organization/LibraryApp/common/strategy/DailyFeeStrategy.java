package com.organization.LibraryApp.common.strategy;

import java.time.temporal.ChronoUnit;

import com.organization.LibraryApp.loan.model.Loan;

public class DailyFeeStrategy implements FeeStrategy{

    private static double dailyFee;

    public DailyFeeStrategy(double dailyFee) {
        this.dailyFee = dailyFee;
    }

    @Override
    public double calculateFee(Loan loan) {
        if(loan.getReturnDate() == null) return 0;
        long days = ChronoUnit.DAYS.between(loan.getLoanDate(), loan.getReturnDate());
        return dailyFee * days;
    }
}
