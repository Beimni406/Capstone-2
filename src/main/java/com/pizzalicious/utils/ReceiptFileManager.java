package com.pizzalicious.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import com.pizzalicious.models.Order;

// Manages saving order receipts to a text file
public class ReceiptFileManager {

    // Saves an order receipt into a uniquely named text file
    public static void saveReceipt(Order order) {
        int fileNumber = 1;
        File file;

        // Keep incrementing the file name until one is free
        do {
            file = new File("receipt_" + fileNumber + ".txt");
            fileNumber++;
        } while (file.exists());

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(order.toString());
            System.out.println("Receipt saved to " + file.getName());
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}
