package org.example;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class OrderManager {
    private List<Object> currentOrder = new ArrayList<>();
    public void addItem(Object item){
        currentOrder.add(item);
    }
    public void clearOrder(){
        currentOrder.clear();
    }
    public boolean isEmpty(){
        return currentOrder.isEmpty();
    }
    public List<Object> getItems(){
        return currentOrder;
    }
    public double calculateTotal() {
        double total = 0;
        for (Object item : currentOrder) {
            if (item instanceof PhoBowl) total += ((PhoBowl) item).getPrice();
            else if (item instanceof Drink) total += ((Drink) item).getPrice();
            else if (item instanceof Side) total += ((Side) item).getPrice();
        }
        return total;
    }
    public String generateFullReceiptText() {
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        java.time.format.DateTimeFormatter displayFormatter = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String receiptText = "==================================\n" +
                "          Welcome to Mika Pho Life           \n" +
                "    Date/Time: " + now.format(displayFormatter) + "\n" +
                "==================================\n\n";

        // Loop through every item in the cart and append its full text
        for (Object item : currentOrder) {
            if (item instanceof PhoBowl) {
                receiptText = receiptText + ((PhoBowl) item).getDescription() + "\n";
            } else if (item instanceof Drink) {
                receiptText = receiptText + ((Drink) item).getDescription() + "\n";
            } else if (item instanceof Side) {
                receiptText = receiptText + ((Side) item).getDescription() + "\n";
            }
        }

        double total = calculateTotal();
        receiptText = receiptText + "----------------------------------\n" +
                String.format("TOTAL DUE: $%.2f\n", total) +
                "==================================\n";

        return receiptText;
    }

    public void saveReceipt(double total) {
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        java.time.format.DateTimeFormatter fileFormatter = java.time.format.DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String fileName = "receipts/" + now.format(fileFormatter) + ".txt";

        // Defensive Check: Make sure receipts folder exists
        java.io.File directory = new File("receipts");
        if (!directory.exists()) {
            directory.mkdir();
        }

        try (java.io.FileWriter writer = new java.io.FileWriter(fileName)) {
            writer.write(generateFullReceiptText()); // Pulls the unified master design
            System.out.println("Receipt file saved successfully to: " + fileName);
        } catch (java.io.IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}
