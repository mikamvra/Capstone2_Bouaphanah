package org.example;

import ToppingPackage.*;

import java.util.ArrayList;
import java.util.List;


public class PhoBowl {
    private String type;
    private int size;
    private boolean special;

    private List<MeatToppings> meat = new ArrayList<>();
    private List<MeatToppings> extraMeat = new ArrayList<>();
    private List<PremiumToppings> premium = new ArrayList<>();
    private List<PremiumToppings> extraPremium = new ArrayList<>();
    private List<RegularToppings> regular = new ArrayList<>();
    private List<Condiments> condiments = new ArrayList<>();

    public PhoBowl(String type, int size, boolean special) {
        this.type = type;
        this.size = size;
        this.special = special;
    }

    public void addMeat(MeatToppings m) {
        meat.add(m);
    }

    public void addExtraMeat(MeatToppings m) {
        extraMeat.add(m);
    }

    public void addPremium(PremiumToppings p) {
        premium.add(p);
    }

    public void addExtraPremium(PremiumToppings p) {
        extraPremium.add(p);
    }

    public void addRegular(RegularToppings r) {
        regular.add(r);
    }

    public void addCondiment(Condiments c) {
        condiments.add(c);
    }

    public double getPrice() {
        double price = 0;
        if (size == 1) price = 3.50;
        else if (size == 2) price = 8.50;
        else if (size == 3) price = 9.00;

        if (size == 1) price += meat.size() * 1.00;
        else if (size == 2) price += meat.size() * 2.00;
        else if (size == 3) price += meat.size() * 3.00;

        if (size == 1) price += extraMeat.size() * 0.50;
        else if (size == 2) price += extraMeat.size() * 1.00;
        else if (size == 3) price += extraMeat.size() * 1.50;

        if (size == 1) price += premium.size() * 0.75;
        else if (size == 2) price += premium.size() * 1.50;
        else if (size == 3) price += premium.size() * 2.25;

        if (size == 1) price += extraPremium.size() * 0.30;
        else if (size == 2) price += extraPremium.size() * 0.60;
        else if (size == 3) price += extraPremium.size() * 0.90;
        return price;
    }

    public String getDescirption() {
        String bowlSize = "Large";
        if (size == 1) {
            bowlSize = "Small";
        } else if (size == 2) {
            bowlSize = "Medium";
        }
        String output = bowlSize + " " + type + " Pho";
        if (special) {
            output = output + " (with Extra Broth)";
        }
        output = output + String.format(" [$%.2f]\n", getPrice());

        if (!meat.isEmpty()) {
            output = output + " - Meats: " + getNames(meat) + "\n";
        }
        if (!extraMeat.isEmpty()) {
            output = output + "   - Extra Meats: " + getNames(extraMeat) + "\n";
        }
        if (!premium.isEmpty()) {
            output = output + "   - Premium Toppings: " + getNames(premium) + "\n";
        }
        if (!extraPremium.isEmpty()) {
            output = output + "   - Extra Premiums: " + getNames(extraPremium) + "\n";
        }
        if (!regular.isEmpty()) {
            output = output + "   - Regular Toppings: " + getNames(regular) + "\n";
        }
        if (!condiments.isEmpty()) {
            output = output + "   - Condiments: " + getNames(condiments) + "\n";
        }
            return bowlSize;
        }
        private <T extends Topping > String getNames(List < T > list) {
            List<String> names = new ArrayList<>();
            for (Topping t : list) {
                names.add(t.getName());
            }
            return String.join(", ", names);
        }
}

