import jdk.internal.org.objectweb.asm.tree.ClassNode;

/**
 * Represents the family of identical products. Has type of product and amount of products of this type.
 */
public class ProductPosition {
    public AbstractProduct product;
    public int quantity;

    public ProductPosition(AbstractProduct product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * @return  Total sum of all products of one type
     */
    public double calculateSum() {
        return product.getProductPrice() * quantity;
    }

    /**
     * Changes the quantity of the products of certain type
     * @param quantity  The new number of products
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return  Quantity of products of certain type
     */
    public int getQuantity() {
        return quantity;
    }
}