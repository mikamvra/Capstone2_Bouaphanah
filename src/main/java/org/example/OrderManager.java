package org.example;

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
}
