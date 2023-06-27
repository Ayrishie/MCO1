public class VendingMachine {
    private RegularVendingMachine vendingMachine;

    public VendingMachine() {
        vendingMachine = null;
    }

    public RegularVendingMachine getVendingMachine() {
        return vendingMachine;
    }

    public void setVendingMachine(RegularVendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }
}
