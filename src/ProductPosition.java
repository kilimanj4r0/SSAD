public class ProductPosition {
    private AbstractProduct product;
    private int quantity;

    public double calculateSum() {
        return product.getProductPrice() * quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }
}