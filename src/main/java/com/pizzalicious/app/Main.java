package com.pizzalicious.app;

import com.pizzalicious.models.*;
import com.pizzalicious.utils.ReceiptFileManager;
import java.util.ArrayList;
import java.util.Scanner;

// Entry point of the Pizza-Licious app
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to PIZZA-licious!");
        System.out.println("-------------------------");

        boolean running = true;

        while (running) {
            System.out.println("\n1. Start a New Order");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume leftover newline

            switch (choice) {
                case 1 -> startOrder(scanner);
                case 2 -> {
                    System.out.println("Thank you for visiting PIZZA-licious!");
                    running = false;
                }
                default -> System.out.println("Invalid option. Please choose again.");
            }
        }

        scanner.close();
    }

    private static void startOrder(Scanner scanner) {
        Order order = new Order();

        System.out.println("\nCreating your order...");
        System.out.println("Adding sample items for demo purposes.");

        // Example items (for testing)
        RegularTopping onion = new RegularTopping("Onion");
        PremiumTopping pepperoni = new PremiumTopping("Pepperoni", false);
        Drink coke = new Drink("Large", "Coke");
        GarlicKnot knots = new GarlicKnot(2);

        // Create an anonymous pizza subclass to test (since Pizza is abstract)
        Pizza customPizza = new Pizza(12, "Regular", false) {
            @Override
            public String toString() {
                ArrayList<String> toppings = new ArrayList<>();
                toppings.add(onion.getName());
                toppings.add(pepperoni.getName());
                return size + " inch " + crust + " pizza with " + toppings + " - $" + String.format("%.2f", calculatePrice());
            }
        };

        order.addPizza(customPizza);
        order.addDrink(coke);
        order.addGarlicKnot(knots);

        // Display and save receipt
        System.out.println(order.toString());
        ReceiptFileManager.saveReceipt(order);
    }
}
