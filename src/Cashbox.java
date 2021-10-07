import java.util.ArrayList;

/**
 * Class representing Cashier point in our supermarket
 * Can change the parameters of products passed to it by using special Cashier key (Galya otmena)
 */
public class Cashbox {
    private static final String secretKey = "QWE123321";
    private final ArrayList<ProductPosition> productPositions = new ArrayList<ProductPosition>();
    private int id;

    /**
     * @return ArrayList of all products in our supermarket
     */
    public ArrayList<ProductPosition> getProductList() {
        return productPositions;
    }

    public void changeQuantity(int id, int minusQuantity) {
        for (ProductPosition productPosition : productPositions) {
            if (productPosition.product.id == id) {
                productPosition.quantity -= minusQuantity;
            }
        }
    }

    public ProductPosition getProduct(int id, int number) {
        for (ProductPosition productPosition : productPositions) {
            if (productPosition.product.id == id) {
                if (productPosition.quantity < number) {
                    System.out.println("Too many objects.");
                    return null;
                }
                return new ProductPosition(productPosition.product.makeClone(), number);
            }
        }
        System.out.println("There is no such product");
        return null;
    }

    /**
     * Removes the product from the order
     *
     * @param index
     */
    public void removeProduct(int index) {
        productPositions.remove(index);
    }

    /**
     * Adds product to the order of the customer
     *
     * @param productPosition
     */
    public void addProduct(ProductPosition productPosition) {
        if (checkAvailability(productPosition)) {
            productPositions.get(productPositions.indexOf(productPosition)).quantity += 1;
        }
        productPositions.add(productPosition);
    }

    /**
     * @return The amount of money customer needs to pay to the Cashier
     */
    public double calculateOverallSum(ArrayList<ProductPosition> products) {
        int overallSum = 0;
        for (ProductPosition productPosition : products) {
            overallSum += productPosition.calculateSum();
        }
        return overallSum;
    }

    /**
     * Checks if there are such products in the supermarket
     *
     * @param products positions to check for availability to sell
     * @return true if we are able to sell such products, false otherwise
     */
    public boolean checkAvailability(ArrayList<ProductPosition> products) {
        for (ProductPosition product : products) {
            for (ProductPosition productPosition : productPositions) {
                if (productPosition.product.id == product.product.id) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Checks if there are such product in the supermarket
     *
     * @param product position to check for availability to sell
     * @return true if we are able to sell this product, false otherwise
     */
    public boolean checkAvailability(ProductPosition product) {
        return productPositions.contains(product);
    }
}
