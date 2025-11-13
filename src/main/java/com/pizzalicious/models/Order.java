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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n----- Order Details -----\n");

        if (pizzas.isEmpty() && drinks.isEmpty() && garlicKnots.isEmpty()) {
            sb.append("No items in the order.\n");
        } else {
            if (!pizzas.isEmpty()) {
                sb.append("\nPizzas:\n");
                for (Pizza p : pizzas) {
                    sb.append(" - ").append(p.toString()).append("\n");
                }
            }

            if (!drinks.isEmpty()) {
                sb.append("\nDrinks:\n");
                for (Drink d : drinks) {
                    sb.append(" - ").append(d.toString()).append("\n");
                }
            }

            if (!garlicKnots.isEmpty()) {
                sb.append("\nGarlic Knots:\n");
                for (GarlicKnot g : garlicKnots) {
                    sb.append(" - ").append(g.toString()).append("\n");
                }
            }
        }

        sb.append("\nTotal: $").append(String.format("%.2f", calculateTotal())).append("\n");
        sb.append("--------------------------\n");

        return sb.toString();
    }
}
