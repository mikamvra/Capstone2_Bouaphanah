package org.example;

import javax.imageio.IIOException;
import javax.swing.text.DateFormatter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public void saveReceipt (double total){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter fileFomatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmm");
        DateTimeFormatter displayFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        String fileName ="Receipt/" + now.format(fileFomatter) + ".txt";
        File directory = new File("receipts");
        if (!directory.exists()) {
            directory.mkdir();
        }
        try (FileWriter writer = new FileWriter(fileName)){
            String receiptText = "==================================\n" +
                    "        Mika Pho Life             " +
                    "    Date/Time: " + now.format(displayFormatter) + "\n" +
                    "==================================\n\n";
            for (Object  item : currentOrder){
                if(item instanceof PhoBowl){
                    PhoBowl bowl = (PhoBowl) item;
                    receiptText = receiptText + bowl.getDescirption() + "\n";
                } else if (item instanceof Drink) {
                    Drink drink = (Drink) item;
                    receiptText = receiptText + drink.getDescription() + "\n";
                } else if (item instanceof Side) {
                    Side side = (Side) item;
                    receiptText = receiptText + side.getDescription() + "\n";

                }
            }
            receiptText = receiptText + "----------------------------------------\n" +
                    "TOTAL PAID: $" + String.format("%.2f", total) + "\n" +
                    "=================================\n";

            writer.write(receiptText);
            System.out.println("Receipt saved successfully to: " + fileName);

        }catch (IOException e){
            System.out.println("Error saving receipt" + e.getMessage());
        }
    }
}
