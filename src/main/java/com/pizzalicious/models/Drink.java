package com.pizzalicious.models;

// Represents a drink item that can be added to an order
public class Drink {
    private String size;     // Small, Medium, or Large
    private String flavor;   // Example: Coke, Sprite, Lemonade

    // Constructor
    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    // Getter methods
    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    // Calculates price based on size
    public double getPrice() {
        return switch (size.toLowerCase()) {
            case "small" -> 2.00;
            case "medium" -> 2.50;
            case "large" -> 3.00;
            default -> 0.0;
        };
    }

    // Displays drink info
    @Override
    public String toString() {
        return size + " " + flavor + " - $" + String.format("%.2f", getPrice());
    }
}
