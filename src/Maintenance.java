import java.util.Scanner;

public class Maintenance {
    private RegularVendingMachine vendingMachine;
    private Scanner scanner;

    public Maintenance() {
        vendingMachine = null;
        scanner = new Scanner(System.in);
    }

    public RegularVendingMachine getVendingMachine() {
        return vendingMachine;
    }

    public void setVendingMachine(RegularVendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void performMaintenance(RegularVendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
        boolean done = false;
        while (!done) {
            clearScreen();
            displayMaintenanceMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    refillItem(vendingMachine);
                    break;
                case 2:
                    restockChange(vendingMachine);
                    break;
                case 3:
                    done = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }


    private void displayMaintenanceMenu() {
        System.out.println("Maintenance Menu");
        System.out.println("1. Refill Items");
        System.out.println("2. Restock Change");
        System.out.println("3. Go back");
    }

    private int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public void refillItem(RegularVendingMachine vendingMachine) {
        vendingMachine.displayItems();
        System.out.print("Enter the slot number to refill: ");
        int slotNumber = scanner.nextInt();
        System.out.print("Enter the quantity to refill: ");
        int quantity = scanner.nextInt();
        vendingMachine.refillItem(slotNumber, quantity);
    }

    public void restockChange(RegularVendingMachine vendingMachine) {
        vendingMachine.displayDenominationQuantities();
        System.out.print("Enter the denomination number to restock: ");
        int denominationNumber = scanner.nextInt();
        System.out.print("Enter the quantity to restock: ");
        int quantity = scanner.nextInt();
        vendingMachine.restockChange(denominationNumber, quantity);
    }


    private void clearScreen() {
        // Clear the console screen
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
