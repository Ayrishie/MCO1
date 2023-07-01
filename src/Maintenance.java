import java.util.Scanner;

public class Maintenance {
    private RegularVendingMachine vendingMachine;
    private Scanner scanner;
    private double totalSales; // New variable to store the total payments
    /**
     * Maintenance is a class that represents the maintenance operations of a vending machine.
     * It provides methods to refill items, restock change, update prices, and dispense total payments.
     */
    public Maintenance() {
        vendingMachine = null;
        scanner = new Scanner(System.in);
        totalSales = 0.0; // Initialize total payments to 0
    }

    /**
     * Constructs a new Maintenance object with default values.
     */
    public RegularVendingMachine getVendingMachine() {
        return vendingMachine;
    }

    /**
     * Sets the vending machine associated with the maintenance operations.
     *
     * @param vendingMachine The RegularVendingMachine object to set.
     */
    public void setVendingMachine(RegularVendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    /**
     * Refills an item in the vending machine.
     *
     * @param vendingMachine The RegularVendingMachine object to refill the item.
     */
    public void refillItem(RegularVendingMachine vendingMachine) {
        vendingMachine.displayItems();
        System.out.print("Enter the slot number to refill: ");
        int slotNumber = scanner.nextInt();
        System.out.print("Enter the quantity to refill: ");
        int quantity = scanner.nextInt();
        vendingMachine.refillItem(slotNumber, quantity);
        totalSales = 0;

    }

    /**
     * Restocks the change denominations in the vending machine.
     *
     * @param vendingMachine The RegularVendingMachine object to restock the change denominations.
     */

    public void restockChange(RegularVendingMachine vendingMachine) {
        System.out.print("Enter the denomination number to restock: ");
        int denominationNumber = scanner.nextInt();
        System.out.print("Enter the quantity to restock: ");
        int quantity = scanner.nextInt();
        vendingMachine.restockChange(denominationNumber, quantity);
    }

    /**
     * Updates the price of an item in the vending machine.
     *
     * @param vendingMachine The RegularVendingMachine object to update the item price.
     */
    public void updatePrices(RegularVendingMachine vendingMachine) {
        if (vendingMachine == null) {
            System.out.println("No Vending Machine created yet.");
            return;
        }

        System.out.print("Enter the slot number of the item: ");
        int slotNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the new price for the item: ");
        double newPrice = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        vendingMachine.updateItemPrice(slotNumber, newPrice);
    }

    /**
     * Dispenses the total payments accumulated in the vending machine.
     *
     * @param vendingMachine The RegularVendingMachine object to dispense the total payments.
     */
    public void dispenseTotalPayments(RegularVendingMachine vendingMachine) {
        double totalSales = vendingMachine.getTotalSales();
        System.out.println("Total payments: $" + totalSales);
        System.out.println("\u001B[33mDispensing $" + totalSales);
        System.out.println("Payments dispensed.\u001B[0m");
        totalSales = 0; // Reset total payments after dispensing
    }
}
