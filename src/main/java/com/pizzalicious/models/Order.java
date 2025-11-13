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

    // Adds a pizza to the order
    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    // Adds a drink to the order
    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    // Adds garlic knots to the order
    public void addGarlicKnot(GarlicKnot knot) {
        garlicKnots.add(knot);
    }
}
