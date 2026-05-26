package org.example;

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

            } else if (choice.equals("2")) {

            } else if (choice.equals("3")) {

            } else if (choice.equals("4")) {

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
}
}
