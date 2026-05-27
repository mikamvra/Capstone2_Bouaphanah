package org.example;

import ToppingPackage.Condiments;
import ToppingPackage.MeatToppings;
import ToppingPackage.PremiumToppings;
import ToppingPackage.RegularToppings;

import java.util.Scanner;

public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);
    private static OrderManager orderManager = new OrderManager();

    private static final String[] PHO_TYPES = {"Beef Pho", "Chicken Pho", "Seafood Pho", "Vegan Pho"};
    private static final String[] MEATS = {"Brisket", "Rare Steak", "Meatballs", "Chicken Flakes", "Shrimp", "Fried Tofu"};
    private static final String[] PREMIUMS = {"Soft Boiled Egg", "Quail Eggs", "Steamed Veggies", "Extra Noodles"};
    private static final String[] REGULARS = {"Bean Sprouts", "Thai Basil", "Jalapenos", " Lime Wedges", "White Onions", "Cilantro"};
    private static final String[] CONDIMENTS = {"Sriracha", "Hoisin Sauce", "Chili Oil", "Garlic Vinegar"};
    private static final String[] DRINK_FLAVORS = {"Thai Iced Tea", "Vietnamese Iced Coffee", "Iced Green Tea", "Soda"};
    private static final String[] SIDES = {"Spring Rolls (2pc)", "Egg Rolls (2pc)"};

    public static void main(String[] args) {
        String noodleArt = """
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣦⣤⣤⣤⣤⣤⣶⣶⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⡿⠛⢻⠛⢻⠛⢻⣿⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⡇⠀⡿⠀⣼⠀⢸⣿⡅⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⡇⠀⣿⠀⢹⠀⢸⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣠⣤⣤⡀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⡀⠸⡆⠘⣇⠀⢿⣷⠀⠀⠀⠀⣀⣠⣤⣶⣶⣾⣿⠿⠿⠛⠋⢻⡆
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⣿⠀⢿⣄⣸⣿⣦⣤⣴⠿⠿⠛⠛⠉⠁⢀⣀⣀⣀⣄⣤⣼⣿
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣿⡇⠀⡿⠀⣼⣿⣿⣯⣿⣦⣤⣤⣶⣶⣶⣿⢿⠿⠟⠿⠛⠛⠛⠛⠋
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⠁⣸⠃⢠⡟⢻⣿⣿⣿⣿⣿⣭⣭⣭⣵⣶⣤⣀⣄⣠⣤⣤⣴⣶⣦
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣿⡇⠀⣿⠀⣸⠀⢸⣿⣶⣦⣤⣤⣄⣀⣀⣀⠀⠀⠉⠈⠉⠈⠉⠉⢽⣿
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣸⣿⡇⠀⣿⠀⢸⠀⢸⣿⡿⣿⣿⣿⣿⡟⠛⠻⠿⠿⠿⣿⣶⣶⣶⣶⣿⣿
                ⠀⠀⠀⠀⠀⠀⠀⢀⣤⣶⣿⡿⣿⣿⣿⣷⠀⠹⡆⠘⣇⠈⣿⡟⠛⠛⠛⠾⣿⡳⣄⠀⠀⠀⠀⠀⠀⠈⠉⠉⠁
                ⠀⠀⠀⠀⠀⠀⣰⣿⢟⡭⠒⢀⣐⣲⣿⣿⡇⠀⣷⠀⢿⠀⢸⣏⣈⣁⣉⣳⣬⣻⣿⣷⣀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⣀⣤⣾⣿⡿⠟⠛⠛⠿⣿⣋⣡⠤⢺⡇⠀⡿⠀⣼⠀⢸⣿⠟⠋⣉⢉⡉⣉⠙⠻⢿⣯⣿⣦⣄⠀⠀⠀⠀
                ⢠⣾⡿⢋⣽⠋⣠⠊⣉⠉⢲⣈⣿⣧⣶⣿⠁⢠⣇⣠⣯⣀⣾⠧⠖⣁⣠⣤⣤⣤⣭⣷⣄⠙⢿⡙⢿⣷⡀⠀⠀
                ⢸⣿⣄⠸⣧⣼⣁⡎⣠⡾⠛⣉⠀⠄⣈⣉⠻⢿⣋⠁⠌⣉⠻⣧⡾⢋⡡⠔⠒⠒⠢⢌⣻⣶⣾⠇⣸⣿⡇⠀⠀
                ⣹⣿⣿⣷⣦⣍⣛⠻⠿⠶⢾⣤⣤⣦⣤⣬⣷⣬⣿⣦⣤⣬⣷⣼⣿⣧⣴⣾⠿⠿⠿⢛⣛⣩⣴⣾⣿⣿⡇⠀⠀
                ⣸⣿⣟⡾⣽⣻⢿⡿⣷⣶⣦⣤⣤⣤⣬⣭⣉⣍⣉⣉⣩⣩⣭⣭⣤⣤⣤⣴⣶⣶⣿⡿⣿⣟⣿⣽⣿⣿⡇⠀⠀
                ⢸⣿⡍⠉⠛⠛⠿⠽⣷⣯⣿⣽⣻⣻⣟⢿⣻⢿⡿⣿⣟⣿⣻⢟⣿⣻⢯⣿⣽⣾⣷⠿⠗⠛⠉⠁⢸⣿⡇⠀⠀
                ⠘⣿⣧⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠉⠉⠛⠙⠛⠛⠛⠛⠋⠛⠋⠉⠉⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀    ⣿⡿⠀⠀⠀
                ⠀⠹⣿⣆⠀⠀    ⠀⠀⣴⣿⣷⠀⠀⠀⠀   ⠀   ⣴⣿⣦⡀⠀⠀⠀   ⠀    ⣼⣿⠇⠀⠀⠀
                ⠀⠀⠹⣿⣆⠀⠀⠀⠀⠀⠀⠀⠻⠿⠟⠀⠀⠀⠿⣦⣤⠞⠀⠀⠀⠻⠿⠟⠀⠀⠀⠀⠀    ⢀⣼⣿⠋⠀⠀⠀⠀
                ⠀⠀⠀⠘⢿⣷⣶⣶⣤⣤⣤⣀⣀⣀⡀⣀⠀⡀⠀⠀⠀⡀⣀⡀⣀⣀⣀⣠⣤⣤⣴⣶⣶⣿⡿⠃⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠙⢿⣿⣾⡙⠯⠿⠽⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠿⠙⢋⣿⣿⡿⠋⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠙⠻⢿⣶⣤⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣾⣿⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀
                ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣈⠙⠻⠿⡿⠷⠶⡶⠶⠶⠶⠶⠶⣾⢿⣿⢿⠛⣉⣡⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                """;
        while (true) {
            System.out.println("\n ~~~ Welcome to Mika Pho Life ~~~");
            System.out.println(noodleArt);
            System.out.println("1. New Order ");
            System.out.println("0. Exit App");
            System.out.println("Select an Option: ");

            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                runOrderScreen();
            } else if (choice.equals("0")) {
                System.out.println("Exiting system. Goodbye!");
                break;
            } else {
                System.out.println("Invalid Option. Please 1 or 0 ");
            }
        }
    }

    private static void runOrderScreen() {
        while (true) {
            System.out.println("\n ~~~Order Screen~~~");
            System.out.println("1. Add Pho Bowl");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Main Side");
            System.out.println("4. Checkout");
            System.out.println("0. Cancel Order");
            System.out.print("Select an option: ");

            String choice = scanner.nextLine();
            if (choice.equals("1")) {
                addPhoBowl();
            } else if (choice.equals("2")) {
                addDrink();
            } else if (choice.equals("3")) {
                addSide();
            } else if (choice.equals("4")) {
                if (processCheckout()){
                    return;
                }
            } else if (choice.equals("0")) {
                orderManager.clearOrder();
                System.out.println("Order Canceled!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Returning to Home Screen");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            } else {
                System.out.println("Invalid Option! Please enter a valid option!");
            }
        }
    }

    private static void addPhoBowl() {
        System.out.println("\n~~~ Customized Pho Bowl ~~~");

        int type = -1;
        while (true) {
            System.out.println("Select Pho Type:");
            for (int i = 0; i < PHO_TYPES.length; i++) {
                System.out.printf(" %d) %s\n", i + 1, PHO_TYPES);
            }
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= PHO_TYPES.length) {
                    type = choice - 1;
                    break;
                }
                System.out.println("Invalid Choice! Choose an item from the list.");
            } catch (NumberFormatException e) {
                System.out.println("Input must be a valid number.");
            }
        }
        String types = PHO_TYPES[type];
        int size = -1;
        while (true) {
            System.out.println("Select Size:\n  1) Small\n  2) Medium\n  3) Large");
            try {
                size = Integer.parseInt(scanner.nextLine());
                if (size == 1 || size == 2 || size == 3) {
                    break;
                }
                System.out.println("Invalid option. Enter 1, 2, or 3.");
            } catch (NumberFormatException e) {
                System.out.println("Input must be a number.");
            }
        }
        boolean special = false;
        while (true) {
            System.out.println("Would you like this add extra broth?");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equalsIgnoreCase("Yes")) {
                special = true;
                break;
            } else if (input.equalsIgnoreCase("No")) {
                special = false;
                break;
            } else {
                System.out.println("Please answer with Yes or No!");
            }
        }
        PhoBowl bowl = new PhoBowl(types, size, special);
        System.out.println("Select Base Meats (Commas, or press Enter for none):");
        for (int i = 0; i < MEATS.length; i++) System.out.printf("  %d) %s\n", i + 1, MEATS[i]);
        String[] meatChoices = scanner.nextLine().split(",");
        for (String c : meatChoices) {
            String clean = c.trim();
            if (!clean.isEmpty()) {
                try {
                    int id = Integer.parseInt(clean) - 1;
                    if (id >= 0 && id < MEATS.length) {
                        bowl.addMeat(new MeatToppings(MEATS[id]));
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        System.out.println(" Add extra meat? ");
        if (scanner.nextLine().equalsIgnoreCase("Yes")) {
            System.out.println("Select Extra Meats (Commas): ");
            meatChoices = scanner.nextLine().split(",");
            for (String c : meatChoices) {
                String clean = c.trim();
                if (!clean.isEmpty()) {
                    try {
                        int id = Integer.parseInt(clean) - 1;
                        if (id >= 0 && id < MEATS.length) {
                            bowl.addExtraMeat(new MeatToppings(MEATS[id]));
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
        System.out.println("Select Premium Toppings (Commas, or press Enter for none): ");
        for (int i = 0; i < PREMIUMS.length; i++) System.out.printf("  %d) %s\n", i + 1, PREMIUMS[i]);
        String[] premChoices = scanner.nextLine().split(",");
        for (String c : premChoices) {
            String clean = c.trim();
            if (!clean.isEmpty()) {
                try {
                    int id = Integer.parseInt(clean) - 1;
                    if (id >= 0 && id < PREMIUMS.length) {
                        bowl.addPremium(new PremiumToppings(PREMIUMS[id]));
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        System.out.println("Would you like extra Premium Toppings? ");
        if (scanner.nextLine().equalsIgnoreCase("Yes")) {
            System.out.println("Select Extra Meats (Commas): ");
            premChoices = scanner.nextLine().split(",");
            for (String c : premChoices) {
                String clean = c.trim();
                if (!clean.isEmpty()) {
                    try {
                        int id = Integer.parseInt(clean) - 1;
                        if (id >= 0 && id < PREMIUMS.length) {
                            bowl.addExtraPremium(new PremiumToppings(PREMIUMS[id]));
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
        System.out.println("Select Regular Toppings (Commas, or press Enter for none): ");
        for (int i = 0; i < REGULARS.length; i++) System.out.printf("  %d) %s\n", i + 1, REGULARS[i]);
        String[] regChoices = scanner.nextLine().split(",");
        for (String c : regChoices) {
            String clean = c.trim();
            if (!clean.isEmpty()) {
                try {
                    int id = Integer.parseInt(clean) - 1;
                    if (id >= 0 && id < REGULARS.length) {
                        bowl.addRegular(new RegularToppings(REGULARS[id]));
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        System.out.println("Select Condiments (Commas, or press Enter for none): ");
        for (int i = 0; i < CONDIMENTS.length; i++) System.out.printf("  %d) %s\n", i + 1, CONDIMENTS[i]);
        String[] condChoices = scanner.nextLine().split(",");
        for (String c : condChoices) {
            String clean = c.trim();
            if (!clean.isEmpty()) {
                try {
                    int id = Integer.parseInt(clean) - 1;
                    if (id >= 0 && id < CONDIMENTS.length) {
                        bowl.addCondiment(new Condiments(CONDIMENTS[id]));
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        orderManager.addItem(bowl);
        System.out.println("Pho Bowl added successfully! ");
    }

    private static void addDrink() {
        System.out.println("\n ~~~ Add Drink ~~~");


        int id = -1;
        while (true) {
            System.out.println("Select Flavor:");
            for (int i = 0; i < DRINK_FLAVORS.length; i++) System.out.printf("  %d) %s\n", i + 1, DRINK_FLAVORS[i]);
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= DRINK_FLAVORS.length) {
                    id = choice - 1;
                    break;
                }
                System.out.println("Invalid Option. Try Again.");
            } catch (NumberFormatException e) {
                System.out.println(" Invalid Option. Please Choose a Valid Number.");
            }
        }
        String size = "Large";
        while (true) {
            System.out.println("Select Size:\n  1) Small\n  2) Medium\n  3) Large");
            String input = scanner.nextLine().trim();
            if (input.equals("1")) {
                size = "Small";
                break;
            } else if (input.equals("2")) {
                size = "Medium";
                break;
            } else if (input.equals("3")) {
                size = "Large";
                break;
            } else {
                System.out.println("Invalid selection. Please explicitly enter 1, 2, or 3.");
            }
        }
        orderManager.addItem(new Drink(DRINK_FLAVORS[id], size));
        System.out.println("Drink added successfully!");
    }

    private static void addSide() {
        System.out.println("\n ~~~ Add Main Side ~~~");

        int id = -1;
        while (true) {
            System.out.println(" Select Side:");
            for (int i = 0; i < SIDES.length; i++) System.out.printf("  %d) %s\n", i + 1, SIDES[i]);
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= SIDES.length) {
                    id = choice - 1;
                    break;
                }
                System.out.println("Out of range. Try again.");
            } catch (NumberFormatException e) {
                System.out.println("Input must be a valid number.");
            }
        }
        orderManager.addItem(new Side(SIDES[id]));
        System.out.println("Side Added!");
    }
    private static boolean processCheckout (){
        if (orderManager.isEmpty()){
            System.out.println("Your Order is Empty!");
            return false;
        }
        System.out.println(
                "    _________\n" +
                "   /  Check /,\n" +
                "  /  out   //\n" +
                " / Details//\n" +
                "(________(/\n");
        for (Object item : orderManager.getItems()) {
            if (item instanceof PhoBowl) System.out.println(((PhoBowl) item).getDescirption());
            else if (item instanceof Drink) System.out.println(((Drink) item).getDescription());
            else if (item instanceof Side) System.out.println(((Side) item).getDescription());
        }
        double total = orderManager.calculateTotal();
        System.out.println("----------------------------------");
        System.out.printf("TOTAL DUE: $%.2f\n", total);
        System.out.println("==================================");

        while (true){
            System.out.println("1. Confirm and Print Receipt");
            System.out.println("2. Return to Order Screen");
            System.out.println("3. Cancel Order");
            System.out.println("Select Option: ");

            String input = scanner.nextLine().trim();
            if (input.equals("1")){
                orderManager.saveReceipt(total);
                orderManager.clearOrder();
            } else if (input.equals("2")){
                return false;
            } else if (input.equals("3")){
                orderManager.clearOrder();
                System.out.println("Order has been canceled!");
                return true;
            } else {
                System.out.println("Invalid Option. Try again!");
            }
        }
    }
}