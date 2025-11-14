package com.pizzalicious.app;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to PIZZA-licious!");
        System.out.println("----------------------------");
        while (running) {
            System.out.println("\n1. Start a New Order");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    startOrder(scanner);
                    break;
                case "0":
                    System.out.println("Thank you for visiting PIZZA-licious!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    private static void startOrder(Scanner scanner) {
        System.out.println("\n=== Starting New Order ===");
        boolean ordering = true;
        ArrayList<String> orderItems = new ArrayList<>();
        double totalCost = 0.0;

        while (ordering) {
            System.out.println("\n===== ORDER MENU =====");
            System.out.println("1) Add Pizza");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Garlic Knots");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.print("Enter choice: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    double pizzaCost = addPizza(scanner, orderItems);
                    totalCost += pizzaCost;
                    break;
                case "2":
                    double drinkCost = addDrink(scanner, orderItems);
                    totalCost += drinkCost;
                    break;
                case "3":
                    double knotsCost = addGarlicKnots(scanner, orderItems);
                    totalCost += knotsCost;
                    break;
                case "4":
                    checkout(orderItems, totalCost);
                    ordering = false;
                    break;
                case "0":
                    System.out.println("Order canceled.");
                    ordering = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static double addPizza(Scanner scanner, ArrayList<String> orderItems) {
        System.out.println("\n--- Building Your Pizza ---");

        // Pizza size
        System.out.println("Choose pizza size:");
        System.out.println("1) 8 inch (Personal) - $8.50");
        System.out.println("2) 12 inch (Medium) - $12.00");
        System.out.println("3) 16 inch (Large) - $16.50");
        System.out.print("Enter choice: ");
        String sizeChoice = scanner.nextLine();

        String size;
        double basePrice;
        switch (sizeChoice) {
            case "1":
                size = "Personal (8\")";
                basePrice = 8.50;
                break;
            case "2":
                size = "Medium (12\")";
                basePrice = 12.00;
                break;
            case "3":
                size = "Large (16\")";
                basePrice = 16.50;
                break;
            default:
                System.out.println("Invalid choice, defaulting to Medium.");
                size = "Medium (12\")";
                basePrice = 12.00;
        }

        // Crust type
        System.out.println("\nChoose crust type:");
        System.out.println("1) Thin");
        System.out.println("2) Regular");
        System.out.println("3) Thick");
        System.out.println("4) Cauliflower");
        System.out.print("Enter choice: ");
        String crustChoice = scanner.nextLine();

        String crust;
        switch (crustChoice) {
            case "1":
                crust = "Thin";
                break;
            case "2":
                crust = "Regular";
                break;
            case "3":
                crust = "Thick";
                break;
            case "4":
                crust = "Cauliflower";
                break;
            default:
                System.out.println("Invalid choice, defaulting to Regular.");
                crust = "Regular";
        }

        // Stuffed crust
        System.out.print("\nStuffed crust? (+$3.00) (y/n): ");
        boolean stuffedCrust = scanner.nextLine().equalsIgnoreCase("y");
        if (stuffedCrust) {
            basePrice += 3.00;
        }

        // Toppings
        ArrayList<String> toppings = new ArrayList<>();
        boolean addingToppings = true;
        double toppingsCost = 0;

        while (addingToppings) {
            System.out.println("\nAdd toppings:");
            System.out.println("1) Meats");
            System.out.println("2) Cheeses");
            System.out.println("3) Regular Toppings");
            System.out.println("4) Sauces");
            System.out.println("5) Sides");
            System.out.println("0) Done with toppings");
            System.out.print("Enter choice: ");
            String toppingChoice = scanner.nextLine();

            switch (toppingChoice) {
                case "1":
                    String meat = selectMeat(scanner);
                    if (meat != null) {
                        toppings.add(meat);
                        // Add meat cost based on size
                        switch (sizeChoice) {
                            case "1":
                                toppingsCost += 1.00; // Personal
                                break;
                            case "2":
                                toppingsCost += 2.00; // Medium
                                break;
                            case "3":
                                toppingsCost += 3.00; // Large
                                break;
                        }
                    }
                    break;
                case "2":
                    String cheese = selectCheese(scanner);
                    if (cheese != null) {
                        toppings.add(cheese);
                        // Add cheese cost based on size
                        switch (sizeChoice) {
                            case "1":
                                toppingsCost += 0.75;  // Personal
                                break;
                            case "2":
                                toppingsCost += 1.50;  // Medium
                                break;
                            case "3":
                                toppingsCost += 2.25;  // Large
                                break;
                        }
                    }
                    break;
                case "3":
                    String veggie = selectRegular(scanner);
                    if (veggie != null) {
                        toppings.add(veggie);
                        // Vegetables are included in base price
                    }
                    break;
                case "4":
                    String sauce = selectSauce(scanner);
                    if (sauce != null) {
                        toppings.add(sauce);
                        // Sauces are included in base price
                    }
                    break;
                case "5":
                    String side = selectSide(scanner);
                    if (side != null) {
                        toppings.add(side);
                        // Sides are included in base price
                    }
                    break;
                case "0":
                    addingToppings = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        double totalPrice = basePrice + toppingsCost;

        // Add pizza to order
        String pizzaDescription = size + " " + crust + " crust" +
                (stuffedCrust ? " (stuffed)" : "") +
                " with " + String.join(", ", toppings) +
                " - $" + String.format("%.2f", totalPrice);
        orderItems.add(pizzaDescription);

        System.out.println("\n=== Pizza Added to Order ===");
        System.out.println(pizzaDescription);
        System.out.println("============================");

        return totalPrice;
    }

    private static String selectMeat(Scanner scanner) {
        // Array of all meat options from the PDF
        String[] meats = {"Pepperoni", "Sausage", "Ham", "Bacon", "Chicken", "Meatball"};

        System.out.println("\nSelect Meat:");
        for (int i = 0; i < meats.length; i++) {
            System.out.println((i + 1) + ") " + meats[i]);
        }
        System.out.println("0) Cancel");
        System.out.print("Enter choice: ");
        String choice = scanner.nextLine();

        try {
            int choiceNum = Integer.parseInt(choice);
            if (choiceNum == 0) {
                return null;
            } else if (choiceNum >= 1 && choiceNum <= meats.length) {
                return meats[choiceNum - 1];
            } else {
                System.out.println("Invalid choice. Please enter a number between 0 and " + meats.length);
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return null;
        }
    }

    private static String selectCheese(Scanner scanner) {
        // Array of all cheese options from the PDF
        String[] cheeses = {"Mozzarella", "Parmesan", "Ricotta", "Goat Cheese", "Buffalo"};

        System.out.println("\nSelect Cheese:");
        for (int i = 0; i < cheeses.length; i++) {
            System.out.println((i + 1) + ") " + cheeses[i]);
        }
        System.out.println("0) Cancel");
        System.out.print("Enter choice: ");
        String choice = scanner.nextLine();

        try {
            int choiceNum = Integer.parseInt(choice);
            if (choiceNum == 0) {
                return null;
            } else if (choiceNum >= 1 && choiceNum <= cheeses.length) {
                return cheeses[choiceNum - 1];
            } else {
                System.out.println("Invalid choice. Please enter a number between 0 and " + cheeses.length);
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return null;
        }
    }

    private static String selectRegular(Scanner scanner) {
        // Array of all regular toppings from the PDF
        String[] regularToppings = {"Onions", "Mushrooms", "Bell Peppers", "Olives", "Tomatoes",
                "Spinach", "Basil", "Pineapple", "Anchovies"};

        System.out.println("\nSelect Regular Topping:");
        for (int i = 0; i < regularToppings.length; i++) {
            System.out.println((i + 1) + ") " + regularToppings[i]);
        }
        System.out.println("0) Cancel");
        System.out.print("Enter choice: ");
        String choice = scanner.nextLine();

        try {
            int choiceNum = Integer.parseInt(choice);
            if (choiceNum == 0) {
                return null;
            } else if (choiceNum >= 1 && choiceNum <= regularToppings.length) {
                return regularToppings[choiceNum - 1];
            } else {
                System.out.println("Invalid choice. Please enter a number between 0 and " + regularToppings.length);
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return null;
        }
    }

    private static String selectSauce(Scanner scanner) {
        // Array of all sauce options from the PDF
        String[] sauces = {"Marinara", "Alfredo", "Pesto", "BBQ", "Buffalo", "Olive Oil"};

        System.out.println("\nSelect Sauce:");
        for (int i = 0; i < sauces.length; i++) {
            System.out.println((i + 1) + ") " + sauces[i]);
        }
        System.out.println("0) Cancel");
        System.out.print("Enter choice: ");
        String choice = scanner.nextLine();

        try {
            int choiceNum = Integer.parseInt(choice);
            if (choiceNum == 0) {
                return null;
            } else if (choiceNum >= 1 && choiceNum <= sauces.length) {
                return sauces[choiceNum - 1];
            } else {
                System.out.println("Invalid choice. Please enter a number between 0 and " + sauces.length);
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return null;
        }
    }

    private static String selectSide(Scanner scanner) {
        // Array of all side options from the PDF
        String[] sides = {"Red Pepper", "Parmesan"};

        System.out.println("\nSelect Side:");
        for (int i = 0; i < sides.length; i++) {
            System.out.println((i + 1) + ") " + sides[i]);
        }
        System.out.println("0) Cancel");
        System.out.print("Enter choice: ");
        String choice = scanner.nextLine();

        try {
            int choiceNum = Integer.parseInt(choice);
            if (choiceNum == 0) {
                return null;
            } else if (choiceNum >= 1 && choiceNum <= sides.length) {
                return sides[choiceNum - 1];
            } else {
                System.out.println("Invalid choice. Please enter a number between 0 and " + sides.length);
                return null;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return null;
        }
    }

    private static double addDrink(Scanner scanner, ArrayList<String> orderItems) {
        System.out.println("\n--- Adding Drink ---");

        System.out.println("Choose drink size:");
        System.out.println("1) Small - $2.00");
        System.out.println("2) Medium - $2.50");
        System.out.println("3) Large - $3.00");
        System.out.print("Enter choice: ");
        String sizeChoice = scanner.nextLine();

        String size;
        double price;
        switch (sizeChoice) {
            case "1":
                size = "Small";
                price = 2.00;
                break;
            case "2":
                size = "Medium";
                price = 2.50;
                break;
            case "3":
                size = "Large";
                price = 3.00;
                break;
            default:
                System.out.println("Invalid choice, defaulting to Medium.");
                size = "Medium";
                price = 2.50;
        }

        System.out.println("\nChoose drink flavor:");
        System.out.println("1) Cola");
        System.out.println("2) Lemonade");
        System.out.println("3) Orange Soda");
        System.out.println("4) Raspberry Iced Tea");
        System.out.println("5) Water");
        System.out.print("Enter choice: ");
        String flavorChoice = scanner.nextLine();

        String flavor;
        switch (flavorChoice) {
            case "1":
                flavor = "Cola";
                break;
            case "2":
                flavor = "Lemonade";
                break;
            case "3":
                flavor = "Orange Soda";
                break;
            case "4":
                flavor = "Raspberry Iced Tea";
                break;
            case "5":
                flavor = "Water";
                break;
            default:
                flavor = "Water";
        }

        String drinkDescription = size + " " + flavor + " - $" + String.format("%.2f", price);
        orderItems.add(drinkDescription);

        System.out.println("\n=== Drink Added to Order ===");
        System.out.println(drinkDescription);
        System.out.println("============================");

        return price;
    }

    private static double addGarlicKnots(Scanner scanner, ArrayList<String> orderItems) {
        System.out.println("\n--- Adding Garlic Knots ---");
        System.out.print("Enter quantity (each $1.50): ");
        try {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (quantity <= 0) {
                System.out.println("Invalid quantity. Setting to 1.");
                quantity = 1;
            }
            double price = quantity * 1.50;

            String knotsDescription = quantity + " garlic knots - $" + String.format("%.2f", price);
            orderItems.add(knotsDescription);

            System.out.println("\n=== Garlic Knots Added to Order ===");
            System.out.println(knotsDescription);
            System.out.println("===================================");

            return price;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Defaulting to 1 garlic knot.");
            double price = 1.50;
            String knotsDescription = "1 garlic knot - $" + String.format("%.2f", price);
            orderItems.add(knotsDescription);
            return price;
        }
    }

    private static void checkout(ArrayList<String> orderItems, double totalCost) {
        System.out.println("\n===== ORDER SUMMARY =====");
        if (orderItems.isEmpty()) {
            System.out.println("No items in order.");
        } else {
            for (int i = 0; i < orderItems.size(); i++) {
                System.out.println((i + 1) + ") " + orderItems.get(i));
            }
        }
        System.out.println("----------------------------");
        System.out.printf("TOTAL: $%.2f%n", totalCost);
        System.out.println("\nThank you for your order!");
        System.out.println("Receipt has been generated.");
        System.out.println("============================");
    }
}