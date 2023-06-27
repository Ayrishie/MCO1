import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private RegularVendingMachine vendingMachine;

    public Menu() {
        scanner = new Scanner(System.in);
        vendingMachine = null;
    }

    public void displayMenu() {
        int choice;
        do {
            System.out.println("------- Vending Machine Menu -------");
            System.out.println("1. Create a Vending Machine");
            System.out.println("2. Test a Vending Machine");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");
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

    public void createVendingMachine() {
        System.out.print("Enter the type of Vending Machine (R for Regular, S for Special): ");
        String machineType = scanner.next();

        while (!machineType.equalsIgnoreCase("R")) {
            System.out.println("Invalid machine type. Please try again.");
            System.out.print("Enter the type of Vending Machine (R for Regular, S for Special): ");
            machineType = scanner.next();
        }

        vendingMachine = new RegularVendingMachine();
        System.out.println("Regular Vending Machine created.");
    }

    public void testVendingMachine() {
        if (vendingMachine == null) {
            System.out.println("No Vending Machine created yet.");
            return;
        }

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
}
