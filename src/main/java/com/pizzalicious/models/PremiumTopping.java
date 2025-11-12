package com.pizzalicious.models;

// Represents premium toppings such as meats and cheeses
public class PremiumTopping extends Topping {

    public PremiumTopping(String name, boolean isExtra) {
        // premium toppings cost extra, so isPremium = true
        super(name, true, isExtra);
    }
}
