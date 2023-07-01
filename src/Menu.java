
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private RegularVendingMachine vendingMachine;
    private Maintenance maintenance;

    public Menu() {
        scanner = new Scanner(System.in);
        vendingMachine = null;
        maintenance = new Maintenance(); // Create an instance of Maintenance
    }

    //displays
    private void showTitleScreen() {
        System.out.println();
        System.out.println("\u001B[38;5;196m╔══════════════════════════════════════════╗");
        System.out.println("\u001B[38;5;202m║\u001B[38;5;196m       RRRR    AAAA  IIIIII   OOOOO       \u001B[38;5;202m║");
        System.out.println("\u001B[38;5;208m║\u001B[38;5;196m       R   R  A    A   II     O   O       \u001B[38;5;208m║");
        System.out.println("\u001B[38;5;214m║\u001B[38;5;196m       RRRR   AAAAAA   II     O   O       \u001B[38;5;214m║");
        System.out.println("\u001B[38;5;220m║\u001B[38;5;196m       R  R   A    A   II     O   O       \u001B[38;5;220m║");
        System.out.println("\u001B[38;5;226m║\u001B[38;5;196m       R   R  A    A  IIIII   OOOOO       \u001B[38;5;226m║");
        System.out.print("\u001B[38;5;190m╚══════════════════════════════════════════╝");
        System.out.println("\nWelcome to RAIO Vending Machine Factory and Store!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void showTestVendingMachineSubMenu() {
        System.out.println();
        System.out.println("\u001B[36m*********************************************");
        System.out.println("\u001B[35m>>>>>>>>>>>> Test Vending Machine <<<<<<<<<<<<");
        System.out.println("\u001B[36m*********************************************");
        System.out.println();
        System.out.println("\u001B[32m╔══════════════════════════════════════╗");
        System.out.println("\u001B[32m║           Test Vending Machine       ║");
        System.out.println("\u001B[32m╠══════════════════════════════════════╣");
        System.out.println("\u001B[33m║  1. Test Vending Features            ║");
        System.out.println("\u001B[33m║  2. Maintenance                      ║");
        System.out.println("\u001B[33m║  3. Go back to main menu             ║");
        System.out.println("\u001B[32m╚══════════════════════════════════════╝");
        System.out.println("\u001B[0mEnter your choice (1-3)");
        System.out.print("\t\t=> ");
    }
    private void showColoredMenu() {
        System.out.println();
        System.out.println();
        System.out.println("\u001B[32m╔══════════════════════════════════════╗");
        System.out.println("\u001B[32m║           Vending Machine            ║");
        System.out.println("\u001B[32m╠══════════════════════════════════════╣");
        System.out.println("\u001B[33m║  1. Create a Vending Machine         ║");
        System.out.println("\u001B[33m║  2. Test a Vending Machine           ║");
        System.out.println("\u001B[33m║  3. Exit                             ║");
        System.out.println("\u001B[32m╚══════════════════════════════════════╝");
        System.out.println("\u001B[0mEnter your choice (1-3)");
        System.out.print("\t\t=> ");

    }


    public void createVendingMachine() {
        System.out.println("\u001B[36m╔═══════════════════════════╗");
        System.out.println("║    \u001B[34mR for Regular          \u001B[36m║");
        System.out.println("║    \u001B[34mS for Special          \u001B[36m║");
        System.out.println("╚═══════════════════════════╝\u001B[0m");
        System.out.println("\u001B[0mEnter your choice (R or S)");
        System.out.print("\t\t\t=> ");
        String machineType = scanner.next();
        scanner.nextLine(); // Consume the newline character
        System.out.println();
        System.out.println();

        while (!machineType.equalsIgnoreCase("R")) {
            System.out.println("\u001B[36m╔═══════════════════════════╗");
            System.out.println("║    \u001B[34mR for Regular          \u001B[36m║");
            System.out.println("║    \u001B[34mS for Special          \u001B[36m║");
            System.out.println("╚═══════════════════════════╝\u001B[0m");
            System.out.println("\u001B[0mEnter your choice (R or S)");
            System.out.print("\t\t\t=> ");
            machineType = scanner.next();
            scanner.nextLine(); // Consume the newline character
        }

        vendingMachine = new RegularVendingMachine();
        System.out.println();
        String coolText =
                "\t╔══════════════════════════╗\n" +
                        "\t║                          ║\n" +
                        "\t║  Regular Vending Machine ║\n" +
                        "\t║        created.          ║\n" +
                        "\t║                          ║\n" +
                        "\t╚══════════════════════════╝";

        System.out.println(coolText);
        System.out.println();
        System.out.println();

    }
    public void displayMenu() {
        showTitleScreen(); // display once
        int choice;
        boolean vendingMachineCreated = false;

        do {
            clearScreen();
            showColoredMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createVendingMachine();
                    vendingMachineCreated = true;
                    break;
                case 2:
                    if (!vendingMachineCreated) {
                        System.out.println();
                        System.out.println("\u001b[31m No Vending Machine created yet.");
                        System.out.println("\u001b[31m Please create a Vending Machine first.\u001B[0m");
                        continue;
                    }
                    testVendingMachineSubMenu();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 3);
    }


    //methods or fucntions
    public void testVendingMachineSubMenu() {
        int option = 0;
        do {
            clearScreen();
            showTestVendingMachineSubMenu();
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    testVendingFeatures();
                    break;
                case 2:
                    performMaintenance();
                    break;
                case 3:
                    System.out.println("Going back to the main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (option != 3);
    }


    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    private void testVendingFeatures() {
        vendingMachine.displayItems();

        System.out.print("Enter the item number you want to purchase (1-" + vendingMachine.getSlotCount() + "): ");
        int itemNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the payment denomination (1-9): ");
        int paymentDenomination = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (vendingMachine.processTransaction(itemNumber - 1, paymentDenomination)) {
            System.out.println();
            System.out.println("Transaction completed successfully.");
            System.out.println();
        } else {
            System.out.println();
            System.out.println("Transaction failed.");
            System.out.println();
        }
    }

    private void performMaintenance() {
        if (maintenance.getVendingMachine() == null) {
            maintenance.setVendingMachine(vendingMachine); // Pass the reference to Maintenance
        }

        int option = 0;
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read user input

        do {
            System.out.println();
            System.out.println();
            System.out.println("\u001B[92m╔════════════════════════════╗");
            System.out.println("\u001B[92m║     Maintenance Menu       ║");
            System.out.println("\u001B[92m╠════════════════════════════╣");
            System.out.println("\u001B[92m║ 1. Refill Items            ║");
            System.out.println("\u001B[92m║ 2. Restock Change          ║");
            System.out.println("\u001B[92m║ 3. Update Prices           ║");
            System.out.println("\u001B[92m║ 4. Dispense Payments       ║");
            System.out.println("\u001B[92m║ 5. Print Summary           ║");
            System.out.println("\u001B[92m║ 6. Go Back                 ║");
            System.out.println("\u001B[92m╚════════════════════════════╝");
            System.out.print("\u001B[92mEnter your choice (1-6): ");


            option = scanner.nextInt(); // Read the user's choice

            switch (option) {
                case 1:
                    maintenance.refillItem(vendingMachine);
                    break;
                case 2:
                    maintenance.restockChange(vendingMachine);
                    break;
                case 3:
                    maintenance.updatePrices(vendingMachine);
                    break;
                case 4:
                    maintenance.dispenseTotalPayments(vendingMachine);
                    break;
                case 5:
                    vendingMachine.printSummary();
                    break;
                case 6:
                    System.out.println("Going back to the main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (option != 6); // Exit the loop when the user chooses option 6

        scanner.close(); // Close the scanner to release resources
    }


    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMenu();
    }
}

