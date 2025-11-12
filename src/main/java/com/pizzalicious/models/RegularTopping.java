package com.pizzalicious.models;

public class RegularTopping extends Topping {

    public RegularTopping(String name) {
        // regular toppings are not premium and not extra by default
        super(name, false, false);
    }
}
