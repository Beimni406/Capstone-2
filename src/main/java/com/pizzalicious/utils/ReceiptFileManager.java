package com.pizzalicious.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.pizzalicious.models.Order;

// Manages saving order receipts to a text file
public class ReceiptFileManager {

    // Saves an order receipt into a uniquely named text file with timestamp
    public static void saveReceipt(Order order) {
        // Get current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");
        String timestamp = now.format(formatter);

        // Build file name using timestamp
        String fileName = "receipt_" + timestamp + ".txt";
        File file = new File(fileName);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(order.toString());
            System.out.println("Receipt saved to " + file.getName());
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
