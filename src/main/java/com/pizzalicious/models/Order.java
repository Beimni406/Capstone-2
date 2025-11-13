package com.pizzalicious.models;

import java.util.ArrayList;

// Represents a customer's order containing pizzas, drinks, and garlic knots
public class Order {
    private ArrayList<Pizza> pizzas;
    private ArrayList<Drink> drinks;
    private ArrayList<GarlicKnot> garlicKnots;

    public Order() {
        pizzas = new ArrayList<>();
        drinks = new ArrayList<>();
        garlicKnots = new ArrayList<>();
    }
}
