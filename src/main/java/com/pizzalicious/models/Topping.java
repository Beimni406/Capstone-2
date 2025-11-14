package com.pizzalicious.models;

public abstract class Topping {
    protected String name;
    protected double price;
    protected boolean isExtra;

    public Topping(String name, double price, boolean isExtra) {
        this.name = name;
        this.price = price;
        this.isExtra = isExtra;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isExtra() {
        return isExtra;
    }

    @Override
    public String toString() {
        return (isExtra ? "Extra " : "") + name + " - $" + String.format("%.2f", price);
    }
}