public class ProductPosition {
    private AbstractProduct product;
    private int quantity;

    public double calculateSum() {
        return 0.0;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}