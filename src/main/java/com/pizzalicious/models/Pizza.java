package com.pizzalicious.models;

import java.util.ArrayList;

public abstract class Pizza {
    protected int size;            // 8, 12, or 16 inches
    protected String crust;        // thin, regular, thick, cauliflower
    protected boolean stuffedCrust;
    protected ArrayList<String> toppings = new ArrayList<>();
}
