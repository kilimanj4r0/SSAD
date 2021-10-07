/** Represents the family of identical products. Has type of product and amount of products of this type. */
public class ProductPosition {
    private AbstractProduct product;
    private int quantity;

    /** Returns the total sum of all products of one type */
    public double calculateSum() {
        return product.getProductPrice() * quantity;
    }

    /** Returns the quantity of products of certain type */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Changes the quantity of the products of certain type
     *
     * @param quantity The new number of products
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}