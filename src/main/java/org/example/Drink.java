package org.example;

import static org.example.Color.*;

public class Drink {
    private String flavor;
    private String size;

    public Drink(String flavor, String size) {
        this.flavor = flavor;
        this.size = size;
    }
    public double getPrice(){
        if (size.equalsIgnoreCase("Small")) {
            return 2.00;
        } else if (size.equalsIgnoreCase("Medium")) {
            return 2.50;
        } else if (size.equalsIgnoreCase("Large")) {
            return 3.00;
        } else {
            return 0.00;
        }
    }
    public String getDescription(){
        return size + " Drink (" + flavor + ") - "+ BOLD_RED + "$" +String.format("%.2f" + RESET, getPrice());
    }
}
