package com.pizzalicious.models;

public abstract class Topping {
    protected String name;
    protected boolean isPremium;   // true if it's meat or cheese
    protected boolean isExtra;     // if customer adds extra portion
}
