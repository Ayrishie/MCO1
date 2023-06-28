import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private RegularVendingMachine vendingMachine;

    public Menu() {
        scanner = new Scanner(System.in);
        vendingMachine = null;
    }

    public void displayMenu() {
        showTitleScreen(); // display once
        int choice;
        do {
            clearScreen();
            clearScreen();
            showColoredMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createVendingMachine();
                    break;
                case 2:
                    testVendingMachine();
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

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

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

    private void showColoredMenu() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("\u001B[36m*********************************************");
        System.out.println("\u001B[35m>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("\u001B[36m*********************************************");
        System.out.println();
        System.out.println("\u001B[32m╔══════════════════════════════════════╗");
        System.out.println("\u001B[32m║           Vending Machine            ║");
        System.out.println("\u001B[32m╠══════════════════════════════════════╣");
        System.out.println("\u001B[33m║  1. Create a Vending Machine         ║");
        System.out.println("\u001B[33m║  2. Test a Vending Machine           ║");
        System.out.println("\u001B[33m║  3. Exit                             ║");
        System.out.println("\u001B[32m╚══════════════════════════════════════╝");
        System.out.println("\u001B[37mEnter your choice (1-3)");
        System.out.print("\t\t=> ");

    }


    public void createVendingMachine() {
        System.out.println("\u001B[36m╔═══════════════════════════╗");
        System.out.println("║    \u001B[34mR for Regular          \u001B[36m║");
        System.out.println("║    \u001B[34mS for Special          \u001B[36m║");
        System.out.println("╚═══════════════════════════╝\u001B[0m");
        System.out.println("\u001B[37mEnter your choice (R or S)");
        System.out.print("\t\t\t=> ");
        String machineType = scanner.next();


        while (!machineType.equalsIgnoreCase("R")) {
            System.out.println("\u001B[36m╔═══════════════════════════╗");
            System.out.println("║    \u001B[34mR for Regular          \u001B[36m║");
            System.out.println("║    \u001B[34mS for Special          \u001B[36m║");
            System.out.println("╚═══════════════════════════╝\u001B[0m");
            System.out.println("\u001B[37mEnter your choice (R or S)");
            System.out.print("\t\t\t=> ");
            machineType = scanner.next();
        }

        vendingMachine = new RegularVendingMachine();
        System.out.println();
        System.out.println("\t\t   \u001B[31mRegular Vending Machine created.\u001B[0m");

        System.out.println();


    }

    public void testVendingMachine() {
        if (vendingMachine == null) {
            System.out.println("No Vending Machine created yet.");
            return;
        }

        System.out.println("Choose an option:");
        System.out.println("1. Test Vending Features");
        System.out.println("2. Test Maintenance Features");
        System.out.print("Enter your choice (1 or 2): ");
        int option = scanner.nextInt();

        if (option == 1) {
            testVendingFeatures();
        } else if (option == 2) {
            testMaintenanceFeatures();
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private void testVendingFeatures() {
        vendingMachine.displayItems();

        System.out.print("Enter the item number you want to purchase (1-" + vendingMachine.getSlotCount() + "): ");
        int itemNumber = scanner.nextInt();

        vendingMachine.displayDenominationQuantities();

        System.out.print("Enter the payment denomination (1-9): ");
        int paymentDenomination = scanner.nextInt();

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

    private void testMaintenanceFeatures() {
        System.out.println("Maintenance features are not implemented yet.");
        // Add code to implement maintenance features
    }


    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMenu();
    }
}