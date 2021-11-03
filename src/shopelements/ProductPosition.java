package shopelements;

/**
 * Represents the family of identical products. Has type of product and amount of products of this type.
 */
public class ProductPosition {
    public Product product;
    public int quantity;

    public ProductPosition(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * @return Total sum of all products of one type
     */
    public double calculateSum() {
        return product.getPrice() * quantity;
    }

    /**
     * @return Quantity of products of certain type
     */
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