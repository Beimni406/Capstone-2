package com.pizzalicious.models;

import java.util.ArrayList;

public abstract class Pizza {
    // --- Commit #1 ---
    protected int size;            // 8, 12, or 16 inches
    protected String crust;        // thin, regular, thick, cauliflower
    protected boolean stuffedCrust;
    protected ArrayList<String> toppings = new ArrayList<>();

    // --- Commit #2 ---
    public Pizza(int size, String crust, boolean stuffedCrust) {
        this.size = size;
        this.crust = crust;
        this.stuffedCrust = stuffedCrust;
    }

    public int getSize() {
        return size;
    }

    public String getCrust() {
        return crust;
    }

    public boolean isStuffedCrust() {
        return stuffedCrust;
    }

    // --- Commit #3 ---
    public double calculatePrice() {
        double basePrice = switch (size) {
            case 8 -> 8.50;
            case 12 -> 12.00;
            case 16 -> 16.50;
            default -> 0;
        };

        // Add $2 if stuffed crust
        if (stuffedCrust) basePrice += 2.00;
        return basePrice;
    }

    // --- Commit #4 ---
    @Override
    public String toString() {
        return size + " inch " + crust + " crust pizza"
                + (stuffedCrust ? " (stuffed crust)" : "")
                + " with toppings: " + toppings
                + "\nPrice: $" + String.format("%.2f", calculatePrice());
    }
}
