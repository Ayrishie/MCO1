import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegularVendingMachine {
    private static final int SLOT_COUNT = 8;
    private static final int ITEM_CAPACITY = 10;
    private static final int DENOMINATION_COUNT = 9;
    private static final double DEFAULT_PRICE = 0.0;
    private List<Integer> denominationValues;
    private List<String> itemSlots;
    private List<Integer> itemQuantities;
    private List<Double> itemPrices;
    private List<Integer> denominationQuantities;
    private List<Double> itemCalories;  // New list to hold calorie counts
    private double totalSales;
    private int transactionCount;
    private Scanner scanner;

    private List<String> denominationNames;

    public RegularVendingMachine() {
        itemSlots = new ArrayList<>();
        itemQuantities = new ArrayList<>();
        itemPrices = new ArrayList<>();
        itemCalories = new ArrayList<>();  // Initialize the calorie list
        denominationQuantities = new ArrayList<>();
        totalSales = 0.0;
        transactionCount = 0;
        scanner = new Scanner(System.in);

        initializeDenominationValues();
        initializeItemSlots();
        initializeItemPrices();
        initializeDenominationQuantities();
        initializeDenominationNames();
        setItemCalories();  // Call the method to set calorie counts
        setItemPrices();   // Call the method to set item prices
        setDenominationQuantities();
    }


    private void initializeItemSlots() {
        itemSlots.add("Bread");
        itemSlots.add("Pizza Sauce");
        itemSlots.add("Cheese");
        itemSlots.add("Meat toppings");
        itemSlots.add("Vegetable toppings");Condiments");

        itemSlots.add("       itemSlots.add("Box");
        itemSlots.add("Softdrink");

        for (int i = 0; i < SLOT_COUNT; i++) {
            itemQuantities.add(ITEM_CAPACITY); // Set initial quantity to 10
            itemCalories.add(0.0); // Add a default calorie value of 0 for each item
        }
    }


    private void initializeItemPrices() {
        for (int i = 0; i < SLOT_COUNT; i++) {
            itemPrices.add(DEFAULT_PRICE);
        }
    }

    public void setItemPrices() {
        System.out.println("\t --------- Set Item Prices ---------");
        System.out.print("Enter the prices for available items: ");
        System.out.println();
        for (int i = 0; i < SLOT_COUNT; i++) {
            String itemName = itemSlots.get(i);
            System.out.print("\t\t    " + (i + 1) + ". (" + itemName + "): ");
            double price = scanner.nextDouble();
            itemPrices.set(i, price);
        }
        System.out.println("----------------------------------");
        System.out.println();
    }

    public void setItemCalories() {
        System.out.println("--------- Set Item Calories ---------");
        System.out.println();
        for (int i = 0; i < SLOT_COUNT; i++) {
            String itemSlot = itemSlots.get(i);
            System.out.print("\t\t  [" + (i + 1) + "]......" + itemSlot + ": ");
            double calories = scanner.nextDouble();
            itemCalories.set(i, calories);
        }
        System.out.println("------------------------------------");
    }

    private void initializeDenominationQuantities() {
        for (int i = 0; i < DENOMINATION_COUNT; i++) {
            denominationQuantities.add(0);
        }
    }

    private void initializeDenominationNames() {
        denominationNames = new ArrayList<>();
        denominationNames.add("1000");
        denominationNames.add("500");
        denominationNames.add("200");
        denominationNames.add("100");
        denominationNames.add("50");
        denominationNames.add("20");
        denominationNames.add("10");
        denominationNames.add("5");
        denominationNames.add("1");
    }


    public void displayItems() {
        System.out.println("-------- Vending Machine Items --------");
        for (int i = 0; i < SLOT_COUNT; i++) {
            String item = itemSlots.get(i);
            double price = itemPrices.get(i);
            int quantity = itemQuantities.get(i);
            System.out.printf("%d. %s - $%.2f (%d remaining)%n", i + 1, item, price, quantity);
        }
        System.out.println("---------------------------------------");
    }

    public void displayDenominationQuantities() {
        System.out.println();
        System.out.println("-------- Denomination Quantities --------");
        for (int i = 0; i < DENOMINATION_COUNT; i++) {
            String denominationName = denominationNames.get(i);
            int quantity = denominationQuantities.get(i);
            System.out.printf("%d.......%s: %d%n", i + 1, denominationName, quantity);
        }
        System.out.println("----------------------------------------");
        System.out.println();
    }

    private void setDenominationQuantities() {
        System.out.println();
        System.out.println("--------- Set Denomination Quantities ---------");
        System.out.println();
        System.out.print("Enter the quantity for denomination:");
        System.out.println();
        for (int i = 0; i < DENOMINATION_COUNT; i++) {
            String denominationName = denominationNames.get(i);
            System.out.print((("\t\t  [" + (DENOMINATION_COUNT - i) + "]......" + denominationName + ": ")));
            int quantity = scanner.nextInt();
            denominationQuantities.set(i, quantity);
        }
        System.out.println("----------------------------------------------");
    }

    public int getSlotCount() {
        return SLOT_COUNT;
    }

    public boolean processTransaction(int slot, int paymentDenomination) {
        if (slot < 0 || slot >= SLOT_COUNT) {
            System.out.println("Invalid item slot.");
            return false;
        }

        double price = itemPrices.get(slot);
        if (price == DEFAULT_PRICE) {
            System.out.println("Item price not set.");
            return false;
        }

        int quantity = itemQuantities.get(slot);
        if (quantity <= 0) {
            System.out.println("Item out of stock.");
            return false;
        }

        double paymentAmount = denominationValues.get(paymentDenomination - 1);
        double change = paymentAmount - price;  // Subtract payment amount from the price

        if (change < 0) {
            System.out.println("Insufficient payment. Please add more to the payment or enter 0 to cancel.");
            return false;
        }

        boolean changeGiven = giveChange(change);
        if (!changeGiven) {
            System.out.println("Exact change not available. Please try another denomination or enter 0 to cancel.");
            return false;
        }

        itemQuantities.set(slot, quantity - 1);
        totalSales += price;
        transactionCount++;

        System.out.println("Item dispensed: " + itemSlots.get(slot));
        if (change > 0) {
            System.out.printf("Change: $%.2f%n", change);
        }

        printReceipt(slot, quantity - 1); // Pass the updated quantity of the item

        return true;
    }

    private boolean giveChange(double change) {
        if (change == 0) {
            return true;
        }

        double remainingChange = change; // Track remaining change

        for (int i = 0; i < DENOMINATION_COUNT; i++) {
            int denominationValue = denominationValues.get(i);
            int denominationQuantity = denominationQuantities.get(i);

            while (remainingChange >= denominationValue && denominationQuantity > 0) {
                remainingChange -= denominationValue; // Subtract denomination value from remaining change
                denominationQuantity--;
                updateDenominationQuantity(i + 1, 1);

                if (remainingChange == 0) {
                    return true;
                }
            }
        }

        return false;
    }


    private boolean checkChangeAvailability(double change) {
        int[] dp = new int[(int) (change * 100) + 1];
        dp[0] = 1;

        for (int i = 0; i < DENOMINATION_COUNT; i++) {
            int denominationValue = denominationValues.get(i);
            int denominationQuantity = denominationQuantities.get(i);

            for (int j = (int) (change * 100); j >= denominationValue; j--) {
                if (dp[j - denominationValue] > 0 && denominationQuantity > 0) {
                    dp[j] = 1;
                    denominationQuantity--;
                }
            }
        }

        return dp[(int) (change * 100)] > 0 && denominationQuantities.stream().noneMatch(qty -> qty < 0);
    }

    private void updateDenominationQuantity(int denomination, int quantity) {
        denominationQuantities.set(denomination - 1, denominationQuantities.get(denomination - 1) - quantity);
    }

    private void initializeDenominationValues() {
        denominationValues = new ArrayList<>();
        denominationValues.add(1000);
        denominationValues.add(500);
        denominationValues.add(200);
        denominationValues.add(100);
        denominationValues.add(50);
        denominationValues.add(20);
        denominationValues.add(10);
        denominationValues.add(5);
        denominationValues.add(1);
    }

    private void printReceipt(int slot, int quantity) {
        System.out.println();
        System.out.println("--------- Transaction Receipt ---------");
        System.out.println("Item purchased: " + itemSlots.get(slot));
        System.out.println("Before quantity: " + (quantity + 1)); // Add 1 to display the correct before quantity
        System.out.println("After quantity: " + quantity);
        System.out.printf("Total Sales: $%.2f%n", totalSales);
        System.out.printf("Total Transactions: %d%n", transactionCount);
        System.out.println();
        System.out.println("-------- Updated Denomination Quantity --------");
        for (int i = 0; i < DENOMINATION_COUNT; i++) {
            System.out.printf("%s: %d%n", denominationNames.get(i), denominationQuantities.get(i));
        }
        System.out.println("--------------------------------------");
        System.out.println();
    }


    public static void main(String[] args) {
        RegularVendingMachine vendingMachine = new RegularVendingMachine();
        vendingMachine.displayItems();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter item slot number (1-" + vendingMachine.getSlotCount() + ") or -1 to exit: ");
            int slot = scanner.nextInt();

            if (slot == -1) {
                break;
            }

            System.out.print("Enter payment denomination (1-9): ");
            int paymentDenomination = scanner.nextInt();

            vendingMachine.displayDenominationQuantities(); // Print denomination quantities after input

            vendingMachine.processTransaction(slot - 1, paymentDenomination);
        }

        scanner.close();
    }
}
