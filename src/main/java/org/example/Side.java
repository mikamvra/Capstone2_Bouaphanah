package org.example;

public class Side {
    private String type;

    public Side(String type) {
        this.type = type;
    }

    public double getPrice() {
        return 1.50;
    }

    public String getDescription() {
        return "Side: " + type + " - $" + String.format("%.2f", getPrice());
    }
}
