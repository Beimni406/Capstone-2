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

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addGarlicKnot(GarlicKnot knot) {
        garlicKnots.add(knot);
    }

    // Calculates total price of the full order
    public double calculateTotal() {
        double total = 0.0;

        for (Pizza pizza : pizzas) {
            total += pizza.calculatePrice();
        }

        for (Drink drink : drinks) {
            total += drink.getPrice();
        }

        for (GarlicKnot knot : garlicKnots) {
            total += knot.getPrice();
        }

        return total;
    }
}
