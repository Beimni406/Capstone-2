package com.pizzalicious.models;

import java.util.ArrayList;

public abstract class Pizza {
    // --- Commit #1 ---
    protected int size;            // 8, 12, or 16 inches
    protected String crust;        // thin, regular, thick, cauliflower
    protected boolean stuffedCrust;
    protected ArrayList<String> toppings = new ArrayList<>();

    // --- Commit #2 ---
    public Pizza(int size, String crust, boolean stuffedCrust) {
        this.size = size;
        this.crust = crust;
        this.stuffedCrust = stuffedCrust;
    }

    public int getSize() {
        return size;
    }

    public String getCrust() {
        return crust;
    }

    public boolean isStuffedCrust() {
        return stuffedCrust;
    }
}
