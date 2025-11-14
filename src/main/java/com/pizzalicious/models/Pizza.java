package com.pizzalicious.models;

import java.util.List;

public class Pizza {
    private int size;
    private String crust;
    private boolean stuffedCrust;
    private List<Topping> toppings;

    public Pizza(int size, String crust, boolean stuffedCrust, List<Topping> toppings) {
        this.size = size;
        this.crust = crust;
        this.stuffedCrust = stuffedCrust;
        this.toppings = toppings;
    }

    public double calculatePrice() {
        // Base price based on size (from PDF table)
        double basePrice = switch (size) {
            case 8 -> 8.50;   // Personal
            case 12 -> 12.00; // Medium
            case 16 -> 16.50; // Large
            default -> 12.00;
        };

        // Stuffed crust premium
        if (stuffedCrust) basePrice += 3.00;

        // Toppings (meat and cheese have prices, regular toppings are included)
        for (Topping topping : toppings) {
            basePrice += topping.getPrice();
        }

        return basePrice;
    }

    @Override
    public String toString() {
        return String.format("%d inch %s crust%s with %d toppings - $%.2f",
                size, crust, stuffedCrust ? " (stuffed)" : "", toppings.size(), calculatePrice());
    }
}