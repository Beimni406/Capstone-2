package com.pizzalicious.models;

public class Drink {
    private String size;
    private String flavor;
    private double price;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;

        switch (size.toLowerCase()) {
            case "small" -> this.price = 2.00;
            case "medium" -> this.price = 2.50;
            case "large" -> this.price = 3.00;
            default -> this.price = 2.00;
        }
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%s %s - $%.2f", size, flavor, price);
    }
}