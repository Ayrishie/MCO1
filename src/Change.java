import java.util.ArrayList;
import java.util.List;

public class Change {
    private static List<Integer> denominations = new ArrayList<>();

    public static void main(String[] args) {
        // Initialize the available denominations
        denominations.add(10);
        denominations.add(5);
        denominations.add(1);

        int productPrice = 11;
        int amountPaid = 20;

        processTransaction(productPrice, amountPaid);
    }

    public static void processTransaction(int productPrice, int amountPaid) {
        if (amountPaid < productPrice) {
            System.out.println("Insufficient funds. Please insert more money.");
            return;
        }

        int change = amountPaid - productPrice;
        if (change == 0) {
            System.out.println("No change. Thank you for your purchase!");
            return;
        }

        List<Integer> availableChange = checkChangeAvailability(change);
        if (availableChange == null) {
            System.out.println("Sorry, unable to provide exact change. Please use a different payment method.");
            return;
        }

        List<Integer> changeDenominations = new ArrayList<>();
        for (int denom : denominations) {
            if (change >= denom && availableChange.contains(denom)) {
                int numDenom = Math.min(change / denom, availableChange.lastIndexOf(denom) + 1);
                changeDenominations.add(denom);
                change -= numDenom * denom;
            }
        }

        if (change > 0) {
            System.out.println("Sorry, unable to provide exact change. Please use a different payment method.");
            return;
        }

        System.out.println("Change breakdown:");
        for (int denom : changeDenominations) {
            int count = countOccurrences(changeDenominations, denom);
            System.out.println("$" + denom + ": " + count);
        }
        System.out.println("Thank you for your purchase!");
    }

    public static List<Integer> checkChangeAvailability(int change) {
        List<Integer> availableChange = new ArrayList<>();
        for (int denom : denominations) {
            if (change >= denom) {
                int numDenom = change / denom;
                for (int i = 0; i < numDenom; i++) {
                    availableChange.add(denom);
                }
                change -= numDenom * denom;
            }
        }

        if (change == 0) {
            return availableChange;
        } else {
            return null;
        }
    }

    public static int countOccurrences(List<Integer> list, int value) {
        int count = 0;
        for (int num : list) {
            if (num == value) {
                count++;
            }
        }
        return count;
    }
}
