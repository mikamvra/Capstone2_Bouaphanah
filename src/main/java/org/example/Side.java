package org.example;

import static org.example.Color.BOLD_RED;
import static org.example.Color.RESET;

public class Side {
    private String type;

    public Side(String type) {
        this.type = type;
    }

    public double getPrice() {
        return 1.50;
    }

    public String getDescription() {
        return "Side: " + type + " - "+ BOLD_RED + "$" +String.format("%.2f" + RESET, getPrice());
    }
}
