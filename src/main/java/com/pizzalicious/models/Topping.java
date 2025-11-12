package com.pizzalicious.models;

public abstract class Topping {
    protected String name;
    protected boolean isPremium;   // true if it's meat or cheese
    protected boolean isExtra;     // if customer adds extra portion

    // Constructor
    public Topping(String name, boolean isPremium, boolean isExtra) {
        this.name = name;
        this.isPremium = isPremium;
        this.isExtra = isExtra;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public boolean isExtra() {
        return isExtra;
    }
}
