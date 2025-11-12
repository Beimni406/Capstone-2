package com.pizzalicious.models;

// Represents regular toppings such as onions, spinach, olives, etc.
public class RegularTopping extends Topping {

    // Commit #1: base constructor
    public RegularTopping(String name) {
        // regular toppings are not premium and not extra by default
        super(name, false, false);
    }

    // Commit #2: helper method to describe the topping type
    public String getTypeDescription() {
        return "Regular topping: " + name;
    }
}
