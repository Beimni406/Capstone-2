package com.pizzalicious.utils;

import java.io.FileWriter;
import java.io.IOException;
import com.pizzalicious.models.Order;

// Manages saving order receipts to a text file
public class ReceiptFileManager {

    // Saves an order receipt into a text file
    public static void saveReceipt(Order order) {
        try {
            FileWriter writer = new FileWriter("receipt.txt");
            writer.write(order.toString());
            writer.close();
            System.out.println("Receipt saved to receipt.txt");
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
