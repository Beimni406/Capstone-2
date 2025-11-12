package com.pizzalicious.models;

// Represents regular toppings such as onions, spinach, olives, etc.
public class RegularTopping extends Topping {

    public RegularTopping(String name) {
        // regular toppings are not premium and not extra by default
        super(name, false, false);
    }

    public String getTypeDescription() {
        return "Regular topping: " + name;
    }

    public void displayInfo() {
        System.out.println("Added " + getTypeDescription());
    }

    @Override
    public String toString() {
        return name + " (Regular)";
    }
}
