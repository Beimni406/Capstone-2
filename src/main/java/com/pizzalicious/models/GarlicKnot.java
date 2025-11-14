package com.pizzalicious.models;

public class GarlicKnot {
    private int quantity;
    private static final double UNIT_PRICE = 1.50;

    public GarlicKnot(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return quantity * UNIT_PRICE;
    }

    @Override
    public String toString() {
        return String.format("%d garlic knots - $%.2f", quantity, getPrice());
    }
}