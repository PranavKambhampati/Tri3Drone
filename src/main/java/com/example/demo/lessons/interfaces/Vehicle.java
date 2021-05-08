package com.example.demo.lessons.interfaces;

public class Vehicle extends TaxableItem{
    private double dealerCost; // needs to be an instance variable due to taking value as a parameter
    private double dealerMarkup; // needs to be an instance variable since it is possible this value can change later

    public Vehicle(double taxRate, double dealerCost, double dealerMarkup) {
        super(taxRate); // super is the first call

        this.dealerCost = dealerCost;
        this.dealerMarkup = dealerMarkup;
    }

    @Override
    public double getListPrice() {
        return dealerCost + dealerMarkup;
    }

    public void changeMarkup(double newMarkup) {
        this.dealerMarkup = newMarkup;
    }
}
