package com.example.demo.lessons;

public abstract class TaxableItem {
    private double taxRate;

    public abstract double getListPrice();

    public TaxableItem(double rate) { taxRate = rate; }

    /**
     * Returns the price of the item including the tax
     * 1. Note: no need to reimplement purchasePrice in Vehicle because
     *    getListPrice is being implemented in vehicle and the tax calculation
     *    remains the same
     */
    public double purchasePrice() { // implementation of the Item interface method
        return getListPrice() * (1 + taxRate);
    }
}
