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

    // Calculates topping price based on size, premium, and extra
    public double getPrice(int size) {
        double price = 0.0;

        if (isPremium) {
            switch (size) {
                case 8 -> price = 1.00;
                case 12 -> price = 2.00;
                case 16 -> price = 3.00;
            }
            if (isExtra) {
                switch (size) {
                    case 8 -> price += 0.50;
                    case 12 -> price += 1.00;
                    case 16 -> price += 1.50;
                }
            }
        }
        return price;
    }
}
