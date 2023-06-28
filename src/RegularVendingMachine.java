import java.util.ArrayList;
import java.util.Collections;
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



    // initialization of items
    private void initializeItemSlots() {
        itemSlots.add("Bread");
        itemSlots.add("Pizza Sauce");
        itemSlots.add("Cheese");
        itemSlots.add("Meat toppings");
        itemSlots.add("Vegetable toppings");
        itemSlots.add("Condiments");
        itemSlots.add("Box");
        itemSlots.add("Softdrink");

        for (int i = 0; i < SLOT_COUNT; i++) {
            itemQuantities.add(ITEM_CAPACITY); // Set initial quantity to 10
            itemCalories.add(0.0); // Add a default calorie value of 0 for each item
        }
    }

    // initialization of Money
    private void initializeDenominationQuantities() {
        for (int i = 0; i < DENOMINATION_COUNT; i++) {
            denominationQuantities.add(0);
        }
    }

    // initialization of Money name
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
    // initialization of Value
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

    private void initializeItemPrices() {
        for (int i = 0; i < SLOT_COUNT; i++) {
            itemPrices.add(DEFAULT_PRICE);
        }
    }



    public int getSlotCount() {
        return SLOT_COUNT;
    }



    // initialization of calories
        public void setItemCalories() {
        System.out.println();
        System.out.println("\t####################################");
        System.out.println("\t------------------------------------");
        System.out.println("\t \u001B[33m┌───────────────────────────────┐\u001B[0m");
        System.out.println("\t \u001B[33m│       Set Item Calories       │\u001B[0m");
        System.out.println("\t \u001B[33m└───────────────────────────────┘\u001B[0m");

        System.out.println();
        System.out.println("Enter the calories for the available items:");
        for (int i = 0; i < SLOT_COUNT; i++) {
            String itemSlot = itemSlots.get(i);
            System.out.print("\t\t[" + (i + 1) + "]......" + itemSlot + ": ");
            double calories = scanner.nextDouble();
            itemCalories.set(i, calories);
        }
        System.out.println("\t------------------------------------");
        System.out.println("\t####################################");
        System.out.println();
        System.out.println("<.............................................>");
    }


    // setters of Prices
    public void setItemPrices() {
        System.out.println();
        System.out.println("\t####################################");
        System.out.println("\t------------------------------------");
        System.out.println("\t \u001B[33m┌───────────────────────────────┐\u001B[0m");
        System.out.println("\t \u001B[33m│       Set Item Prices         │\u001B[0m");
        System.out.println("\t \u001B[33m└───────────────────────────────┘\u001B[0m");

        System.out.println();
        System.out.println("Enter the prices for available items:");

        for (int i = 0; i < SLOT_COUNT; i++) {
            String itemName = itemSlots.get(i);
            System.out.print("\t\t    " + (i + 1) + ". (" + itemName + "): ");
            double price = scanner.nextDouble();
            itemPrices.set(i, price);
        }
        System.out.println("\t----------------------------------");
        System.out.println("\t####################################");
        System.out.println();

    }


    public void setDenominationQuantities() {
        System.out.println();
        System.out.println("\t####################################");
        System.out.println("\t------------------------------------");
        System.out.println("\t \u001B[33m┌───────────────────────────────────┐\u001B[0m");
        System.out.println("\t \u001B[33m│    Set Denomination Quantities    │\u001B[0m");
        System.out.println("\t \u001B[33m└───────────────────────────────────┘\u001B[0m");

        System.out.println();
        System.out.println("Enter the quantities for denominations:");
        for (int i = 0; i < DENOMINATION_COUNT; i++) {
            String denominationName = denominationNames.get(i);
            System.out.print("\t\t  [" + (i + 1) + "]......" + denominationName + ": ");
            int quantity = scanner.nextInt();
            denominationQuantities.set(i, quantity);
        }
        System.out.println("\t####################################");
        System.out.println("\t------------------------------------");
        System.out.println();
        System.out.println("<.............................................>");
    }

    // displaying
    public void displayItems() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("\u001B[36m╔═══════════════════════════════════════════════╗");
        System.out.println("\u001B[36m║              Vending Machine Items            ║");
        System.out.println("\u001B[36m╟───────────────────────────────────────────────╢");
        for (int i = 0; i < SLOT_COUNT; i++) {
            String item = itemSlots.get(i);
            double price = itemPrices.get(i);
            int quantity = itemQuantities.get(i);

            // Add visual elements to enhance the vending machine look
            System.out.printf("\u001B[36m║ %2d. %-20s $%.2f (%2d remaining) ║%n", i + 1, item, price, quantity);
        }
        System.out.println("\u001B[36m╚═══════════════════════════════════════════════╝");
    }

    public void displayDenominationQuantities() {
        System.out.println();
        System.out.println("\u001B[36m╔══════════════════════════════════════════╗");
        System.out.println("\u001B[36m║          Denomination Quantities         ║");
        System.out.println("\u001B[36m╚══════════════════════════════════════════╝");
        for (int i = 0; i < denominationQuantities.size(); i++) {
            int denomination = denominationQuantities.get(i);
            System.out.printf("\t\t\u001B[36m %2d.......$%3d: %2d                     %n", i + 1, denominationValues.get(i), denomination);
        }
        System.out.println("\u001B[36m════════════════════════════════════════════");
    }



    // transaction logic
    public boolean processTransaction(int slot, int paymentDenomination) throws IllegalArgumentException {
        int denominationIndex = 0;
        int denominationQuantity = 0;
        double paymentAmount = 0;
        double change = 0;  // Subtract payment amount from the price

        if (paymentDenomination < 1 || paymentDenomination > DENOMINATION_COUNT) {
            throw new IllegalArgumentException("Invalid payment denomination.");
        }

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

        // Check if there is sufficient quantity for the payment denomination
        denominationIndex = paymentDenomination - 1;
        denominationQuantity = denominationQuantities.get(denominationIndex);

        if (denominationQuantity <= 0) {
            System.out.println("Insufficient quantity for the selected denomination. Transaction canceled.");
            return false;
        }

        paymentAmount = denominationValues.get(paymentDenomination - 1);
        change = paymentAmount - price;  // Subtract payment amount from the price

        if (change < 0) {
            System.out.println("Insufficient payment. Please add more to the payment or enter 0 to cancel.");
            int additionalPayment = scanner.nextInt();

            if (additionalPayment == 0) {
                System.out.println("Transaction canceled.");
                return false;
            }

            paymentAmount += additionalPayment;
            change = paymentAmount - price;

            if (change < 0) {
                System.out.println("Still insufficient payment. Transaction canceled.");
                return false;
            }
        }

        // Check if there is enough change available
        boolean enoughChangeAvailable = checkChangeAvailability(change);
        if (!enoughChangeAvailable) {
            System.out.println("Sorry, there is not enough change in the machine. Please try again later.");
            return false;
        }

        // Update the denomination quantities
        giveChange(change);
        updateDenominationQuantities(Collections.singletonList(paymentDenomination - 1), -1);

        itemQuantities.set(slot, quantity - 1);
        totalSales += price;
        transactionCount++;

        System.out.println("Item dispensed: " + itemSlots.get(slot));
        if (change > 0) {
            System.out.printf("Change: $%.2f%n", change);
        }

        printReceipt(slot, quantity - 1); // Pass the updated quantity of the item
        displayItems(); // Call the displayItems() function to show the updated item quantities

        return true;
    }



    private boolean giveChange(double change) {
        if (change == 0) {
            return true;
        }

        int remainingChange = (int) (change * 100); // Convert change to cents
        List<Integer> usedDenominations = new ArrayList<>();

        for (int i = denominationValues.size() - 1; i >= 0; i--) {
            int denominationValue = denominationValues.get(i);
            int denominationQuantity = denominationQuantities.get(i);

            while (remainingChange >= denominationValue && denominationQuantity > 0) {
                remainingChange -= denominationValue; // Subtract denomination value from remaining change
                denominationQuantity--;
                usedDenominations.add(i);

                if (remainingChange == 0) {
                    updateDenominationQuantities(usedDenominations, -1); // Update the denomination quantities
                    return true;
                }
            }
        }

        // If there is no exact change combination, revert the changes made to denomination quantities
        updateDenominationQuantities(usedDenominations, 1);

        return false;
    }

    //Checker of change Availability
    boolean checkChangeAvailability(double change) {
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

        boolean enoughChange = dp[(int) (change * 100)] > 0 && denominationQuantities.stream().noneMatch(qty -> qty < 0);
        if (!enoughChange) {
            System.out.println("Sorry, there is not enough change in the machine. Please try again later.");
        }

        return enoughChange;
    }

    // denomination update
    private void updateDenominationQuantities(List<Integer> usedDenominations, int quantityChange) {
        for (int denominationIndex : usedDenominations) {
            int currentQuantity = denominationQuantities.get(denominationIndex);
            int updatedQuantity = currentQuantity + quantityChange;
            denominationQuantities.set(denominationIndex, updatedQuantity);
        }
    }

    //displaying reciept
    private void printReceipt(int slot, int quantity) {
        System.out.println();
        System.out.println("--------- Transaction Receipt ---------");
        System.out.println("Item purchased: " + itemSlots.get(slot));
        System.out.println("Before quantity: " + (quantity + 1)); // Add 1 to display the correct before quantity
        System.out.println("After quantity: " + quantity);
        System.out.printf("Total Sales: $%.2f%n", totalSales);
        System.out.printf("Total Transactions: %d%n", transactionCount);
        System.out.println();
        System.out.println("\u001B[36m╔══════════════════════════════════════════╗");
        System.out.println("\u001B[36m║     Updated Denomination Quantities      ║");
        System.out.println("\u001B[36m╚══════════════════════════════════════════╝");
        for (int i = 0; i < denominationQuantities.size(); i++) {
            int denomination = denominationQuantities.get(i);
            System.out.printf("\t\t\u001B[36m %2d.......$%3d: %2d                     %n", i + 1, denominationValues.get(i), denomination);
        }
        System.out.println("\u001B[36m════════════════════════════════════════════");
    }


    //main
    public static void main(String[] args) {
        RegularVendingMachine vendingMachine = new RegularVendingMachine();
        vendingMachine.displayItems();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Enter item slot number (1-" + vendingMachine.getSlotCount() + ") or -1 to exit: ");
                int slot = scanner.nextInt();

                if (slot == -1) {
                    break;
                }

                System.out.print("Enter payment denomination (1-9): ");
                int paymentDenomination = scanner.nextInt();

                vendingMachine.displayDenominationQuantities(); // Print denomination quantities after input

                vendingMachine.processTransaction(slot - 1, paymentDenomination);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }


        scanner.close();
    }
}
