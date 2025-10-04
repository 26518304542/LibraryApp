package com.organization.LibraryApp.strategy;

import com.organization.LibraryApp.model.Loan;

public class VipDiscountStrategy implements FeeStrategy{

    private final double discountRate;
    private final FeeStrategy baseStrategy;


    public VipDiscountStrategy(double discountRate, FeeStrategy baseStrategy) {
        this.discountRate = discountRate;
        this.baseStrategy = baseStrategy;
    }

    @Override
    public double calculateFee(Loan loan) {
        double baseFee = baseStrategy.calculateFee(loan);
        return baseFee * (1-discountRate);
    }

}
