/**
 * Represents the certain type of product.
 */
public class ProductType1 extends AbstractProduct {

    public ProductType1(ProductType1 target) {
        super(target);
    }

    public ProductType1(String name, double price) {
        super(name, price);
    }

    /**
     * Clones the object
     *
     * @return clone of the ProductType1
     */
    @Override public AbstractProduct makeClone() {
        return new ProductType1(this);
    }

    /**
     * Function for creating the product via checking the key
     *
     * @param name  name of the product
     * @param price price of the product
     * @param key   key to get/not get access to the creation of the product
     * @return product in case of succeed, null otherwise
     */
    @Override public AbstractProduct createProduct(int id, String name, double price, String key) {
        if (secretKey.equals(key)) {
            System.out.println("You can not create product. Wrong key.");
            return null;
        }
        return new ProductType1(name, price);
    }

}
