package com.pizzalicious.models;

public class CheeseTopping extends Topping {

    public CheeseTopping(String name, boolean isExtra, int pizzaSize) {
        super(name, getCheesePrice(isExtra, pizzaSize), isExtra);
    }

    private static double getCheesePrice(boolean isExtra, int size) {
        if (isExtra) {
            if (size == 8) return 0.30;
            if (size == 12) return 0.60;
            if (size == 16) return 0.90;
            return 0.60;
        } else {
            if (size == 8) return 0.75;
            if (size == 12) return 1.50;
            if (size == 16) return 2.25;
            return 1.50;
        }
    }
}