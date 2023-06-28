
public class processTransaction(int slot, int paymentDenomination) throws IllegalArgumentException {
        {
        if (paymentDenomination < 1 || paymentDenomination > DENOMINATION_COUNT) {
        throw new IllegalArgumentException("Invalid payment denomination.");
        }

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
        int denominationIndex = paymentDenomination - 1;
        int denominationQuantity = denominationQuantities.get(denominationIndex);
        if (denominationQuantity <= 0) {
        System.out.println("Insufficient quantity for the selected denomination. Transaction canceled.");
        return false;
        }

        double paymentAmount = denominationValues.get(paymentDenomination - 1);
        double change = paymentAmount - price;  // Subtract payment amount from the price

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

        // Update the denomination quantities
        giveChange(change);
        updateDenominationQuantity(paymentDenomination, -1);

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