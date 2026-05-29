package org.example;

import ToppingPackage.*;

import java.util.ArrayList;
import java.util.List;
import static org.example.Color.*;


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

    public String getDescription() {
        String bowlSize = "Large";
        if (size == 1) {
            bowlSize = "Small";
        } else if (size == 2) {
            bowlSize = "Medium";
        }
        double basePrice = 0;
        if (size == 1) basePrice = 3.50;
        else if (size == 2) basePrice = 8.50;
        else if (size == 3) basePrice = 9.00;

        String output = bowlSize + " " + type ;
        if (special) {
            output = output + " (with Extra Broth)";
        }
        output = output + String.format(" \u001B[31m[$%.2f]\u001B[0m\n", basePrice);

        double mPrice = (size == 1) ? 1.00 : (size == 2) ? 2.00 : 3.00;
        double exMPrice = (size == 1) ? 0.50 : (size == 2) ? 1.00 : 1.50;
        double pPrice = (size == 1) ? 0.75 : (size == 2) ? 1.50 : 2.25;
        double exPPrice = (size == 1) ? 0.30 : (size == 2) ? 0.60 : 0.90;

        if (!meat.isEmpty()) {
            output = output + "   - \u001B[36;1mMeats\u001B[0m:\n";
            for (Topping t : meat) {
                output = output + String.format("     * %s \u001B[31m(+$%.2f)\n\u001B[0m", t.getName(), mPrice);
            }
        }
        if (!extraMeat.isEmpty()) {
            output = output + "   - \u001B[36;1mExtra Meats\u001B[0m:\n";
            for (Topping t : extraMeat) {
                output = output + String.format("     * %s \u001B[31m(+$%.2f)\n\u001B[0m", t.getName(), exMPrice);
            }
        }
        if (!premium.isEmpty()) {
            output = output + "   - \u001B[36;1mPremium Toppings\u001B[0m:\n";
            for (Topping t : premium) {
                output = output + String.format("     * %s \u001B[31m(+$%.2f)\n\u001B[0m", t.getName(), pPrice);
            }
        }
        if (!extraPremium.isEmpty()) {
            output = output + "   - \u001B[36;1mExtra Premiums\u001B[0m:\n";
            for (Topping t : extraPremium) {
                output = output + String.format("     * %s \u001B[31m(+$%.2f)\n\u001B[0m", t.getName(), exPPrice);
            }
        }
        if (!regular.isEmpty()) {
            output = output + "   - \u001B[36;1mRegular Toppings\u001B[0m:\n";
            for (Topping t : regular) {
                output = output + "     * " + t.getName() + " \u001B[31m(+$0.00)\n\u001B[0m";
            }
        }
        if (!condiments.isEmpty()) {
            output = output + "   - \u001B[36;1mCondiments\u001B[0m:\n";
            for (Topping t : condiments) {
                output = output + "     * " + t.getName() + " \u001B[31m(+$0.00)\n\u001B[0m";
            }
        }
        output = output + String.format("   --> Bowl Total: \u001B[32;1m$%.2f\n\u001B[0m", getPrice());

        return output;
        }
        private <T extends Topping > String getNames(List < T > list) {
            List<String> names = new ArrayList<>();
            for (Topping t : list) {
                names.add(t.getName());
            }
            return String.join(", ", names);
        }
}

