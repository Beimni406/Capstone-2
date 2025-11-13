package com.pizzalicious.models;

// Represents an order item for garlic knots
public class GarlicKnot {
    private int quantity;   // number of garlic knot orders

    // Constructor
    public GarlicKnot(int quantity) {
        this.quantity = quantity;
    }

    // Getter method
    public int getQuantity() {
        return quantity;
    }

    // Calculates total price for the garlic knots
    public double getPrice() {
        double pricePerOrder = 1.50;  // fixed price per order
        return quantity * pricePerOrder;
    }

    // Displays garlic knot order info
    @Override
    public String toString() {
        return quantity + " order(s) of Garlic Knots - $" + String.format("%.2f", getPrice());
    }
}
