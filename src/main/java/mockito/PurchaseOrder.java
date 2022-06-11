package mockito;

public class PurchaseOrder {
    private final String productName;
    private final int amountToBuy;

    public PurchaseOrder(String productName, int amountToBuy) {
        this.productName = productName;
        this.amountToBuy = amountToBuy;
    }

    public void purchase(Warehouse warehouse) {
        if (warehouse.thereAreProducts(productName, amountToBuy)) {
            warehouse.remove(productName, amountToBuy);
        }
    }
}
