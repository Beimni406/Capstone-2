package com.pizzalicious.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Pizza> pizzas;
    private List<Drink> drinks;
    private List<GarlicKnot> garlicKnots;

    public Order() {
        this.pizzas = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.garlicKnots = new ArrayList<>();
    }

    public void addPizza(Pizza pizza) {
        if (pizza != null) {
            pizzas.add(pizza);
        }
    }

    public void addDrink(Drink drink) {
        if (drink != null) {
            drinks.add(drink);
        }
    }

    public void addGarlicKnot(GarlicKnot garlicKnot) {
        if (garlicKnot != null) {
            garlicKnots.add(garlicKnot);
        }
    }

    public double calculateTotal() {
        double total = 0;
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

        if (!pizzas.isEmpty()) {
            sb.append("Pizzas:\n");
            for (Pizza pizza : pizzas) {
                sb.append("  - ").append(pizza.toString()).append("\n");
            }
        }

        if (!drinks.isEmpty()) {
            sb.append("Drinks:\n");
            for (Drink drink : drinks) {
                sb.append("  - ").append(drink.toString()).append("\n");
            }
        }

        if (!garlicKnots.isEmpty()) {
            sb.append("Garlic Knots:\n");
            for (GarlicKnot knot : garlicKnots) {
                sb.append("  - ").append(knot.toString()).append("\n");
            }
        }

        sb.append(String.format("TOTAL: $%.2f", calculateTotal()));
        return sb.toString();
    }
}