import java.util.Scanner;

public class Maintenance {
    private RegularVendingMachine vendingMachine;
    private Scanner scanner;
    private double totalSales; // New variable to store the total payments

    public Maintenance() {
        vendingMachine = null;
        scanner = new Scanner(System.in);
        totalSales = 0.0; // Initialize total payments to 0
    }

    public RegularVendingMachine getVendingMachine() {
        return vendingMachine;
    }

    public void setVendingMachine(RegularVendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public void refillItem(RegularVendingMachine vendingMachine) {
        vendingMachine.displayItems();
        System.out.print("Enter the slot number to refill: ");
        int slotNumber = scanner.nextInt();
        System.out.print("Enter the quantity to refill: ");
        int quantity = scanner.nextInt();
        vendingMachine.refillItem(slotNumber, quantity);
        totalSales = 0;

    }

    public void restockChange(RegularVendingMachine vendingMachine) {
        System.out.print("Enter the denomination number to restock: ");
        int denominationNumber = scanner.nextInt();
        System.out.print("Enter the quantity to restock: ");
        int quantity = scanner.nextInt();
        vendingMachine.restockChange(denominationNumber, quantity);
    }

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

    public void dispenseTotalPayments(RegularVendingMachine vendingMachine) {
        double totalSales = vendingMachine.getTotalSales();
        System.out.println("Total payments: $" + totalSales);
        System.out.println("Dispensing $" + totalSales);
        System.out.println("Payments dispensed.");
        totalSales = 0; // Reset total payments after dispensing
    }
}
