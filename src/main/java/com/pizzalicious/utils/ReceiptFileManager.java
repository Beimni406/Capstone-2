package com.pizzalicious.utils;

import com.pizzalicious.models.Order;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {
    public static void saveReceipt(Order order) {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String filename = "receipt_" + timestamp + ".txt";

            FileWriter writer = new FileWriter(filename);
            writer.write("=== PIZZA-LICIOUS RECEIPT ===\n");
            writer.write("Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) + "\n");
            writer.write("=============================\n\n");
            writer.write(order.toString());
            writer.write("\n\nThank you for your order!");
            writer.close();

            System.out.println("Receipt saved as: " + filename);
        } catch (IOException e) {
            System.out.println("Error saving receipt: " + e.getMessage());
        }
    }
}