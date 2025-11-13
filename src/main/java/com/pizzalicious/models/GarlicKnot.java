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
}
