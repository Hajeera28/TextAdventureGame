import java.util.Scanner;

public class TextAdventureGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Game introduction
        System.out.println("Welcome to the Text Adventure Game!");
        System.out.println("You find yourself in a mysterious forest...");
        System.out.println("What will you do?");
        System.out.println();

        // Start the game
        playGame(scanner);

        // End of game
        System.out.println("Thanks for playing the Text Adventure Game!");
        scanner.close();
    }

    public static void playGame(Scanner scanner) {
        // Game variables
        int health = 100;
        int coins = 0;
        boolean hasKey = false;

        // Game loop
        while (health > 0) {
            // Display current situation
            System.out.println("--------------------------------------------------");
            System.out.println("Health: " + health);
            System.out.println("Coins: " + coins);
            System.out.println("You are in a clearing. What would you like to do?");
            System.out.println("1. Go north");
            System.out.println("2. Go east");
            System.out.println("3. Go south");
            System.out.println("4. Go west");
            System.out.println("5. Quit game");

            // Get user input
            int choice = getUserChoice(scanner, 1, 5);

            // Process user choice
            switch (choice) {
                case 1:
                    System.out.println("You encounter a river.");
                    System.out.println("1. Swim across");
                    System.out.println("2. Find a bridge");
                    int riverChoice = getUserChoice(scanner, 1, 2);
                    if (riverChoice == 1) {
                        System.out.println("You swim across but lose some health.");
                        health -= 20;
                    } else {
                        System.out.println("You find a sturdy bridge and cross safely.");
                    }
                    break;
                case 2:
                    System.out.println("You discover a treasure chest!");
                    System.out.println("Do you want to open it?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int treasureChoice = getUserChoice(scanner, 1, 2);
                    if (treasureChoice == 1) {
                        System.out.println("You open the chest and find 50 coins!");
                        coins += 50;
                    } else {
                        System.out.println("You leave the treasure chest untouched.");
                    }
                    break;
                case 3:
                    System.out.println("You encounter a locked door.");
                    if (hasKey) {
                        System.out.println("You use the key to unlock the door.");
                        System.out.println("You find an exit and win the game!");
                        return;
                    } else {
                        System.out.println("You need a key to open this door.");
                    }
                    break;
                case 4:
                    System.out.println("You find a merchant selling potions.");
                    System.out.println("Do you want to buy a health potion?");
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int potionChoice = getUserChoice(scanner, 1, 2);
                    if (potionChoice == 1) {
                        System.out.println("You buy a health potion and restore 30 health.");
                        health += 30;
                        if (health > 100) {
                            health = 100; // Cap health at 100
                        }
                    } else {
                        System.out.println("You decide not to buy anything.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the game...");
                    return;
            }

            // Check for game over condition
            if (health <= 0) {
                System.out.println("You have run out of health. Game over!");
            }
        }
    }

    public static int getUserChoice(Scanner scanner, int minChoice, int maxChoice) {
        int choice;
        while (true) {
            System.out.print("Enter your choice (" + minChoice + "-" + maxChoice + "): ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice >= minChoice && choice <= maxChoice) {
                    break;
                } else {
                    System.out.println("Invalid input! Please enter a number between " + minChoice + " and " + maxChoice + ".");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // consume invalid input
            }
        }
        scanner.nextLine(); // consume newline character after reading int
        return choice;
    }
}
