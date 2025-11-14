package com.pizzalicious.models;

public class RegularTopping extends Topping {
    public RegularTopping(String name, boolean isExtra) {
        // Regular toppings are included in base price, so price is 0
        super(name, 0.00, isExtra);
    }
}