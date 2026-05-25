package org.example;

import java.util.Scanner;

public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);
    private static OrderManager orderManager = new OrderManager();

    private static final String[] PHO_TYPES = {"Beef Pho",  "Chicken Pho", "Seafood Pho", "Vegan Pho"};
    private static final String[] MEATS = {"Brisket", "Rare Steak", "Meatballs", "Chicken Flakes", "Shrimp", "Fried Tofu"};
    private static final String[] PREMIUMS = {"Soft Boiled Egg", "Quail Eggs", "Steamed Veggies", "Extra Noodles"};
    private static final String[] REGULARS = {"Bean Sprouts", "Thai Basil", "Jalapenos"," Lime Wedges", "White Onions", "Cilantro"};
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
        while (true){
            System.out.println("\n ~~~ Welcome to Mika Pho Life ~~~");
            System.out.println(noodleArt);
            System.out.println("1. New Order ");
            System.out.println("0. Exit App" );
            System.out.println("Select an Option: ");

            String choice = scanner.nextLine();
            if (choice.equals("1")){
            } else if ( choice.equals("0")) {
                System.out.println("Exiting system. Goodbye!");
                break;
            }else {
                System.out.println("Invalid Option. Please 1 or 0 ");
            }
        }
    }

}
