import java.util.ArrayList;
import static java.lang.System.exit;

/**
 * Class representing Cashier point in our supermarket
 * Can change the parameters of products passed to it by using special Cashier key (Galya otmena)
 */
public class CashBox {
    private static final String secretKey = "QWE123321";
    private int id;
    private ArrayList<ProductPosition> productPositions;

    /**
     * @return  ArrayList of all products in our supermarket
     */
    public ArrayList<ProductPosition> getProductList() {
        return productPositions;
    }

    /**
     * Removes the product from the order
     * @param id
     */
    public void removeProduct(int id) {
        productPositions.remove(id); // TODO: Add checks
    }

    /**
     * Adds product to the order of the customer
     * @param productPosition
     */
    public void addProduct(ProductPosition productPosition) {
        ArrayList<ProductPosition> tmp_products = new ArrayList<>();
        tmp_products.add(productPosition);
        if (!checkAvailability(tmp_products)){
            System.out.println("Such product is not available");
            exit(-1);
        }

        productPositions.add(productPosition);
    }

    /**
     * @return  Number of products in the order (bill)
     */
    public int calculateQuantityOfProducts() {
        int overallQuantity = 0;
        for (ProductPosition productPosition: productPositions) {
            overallQuantity += productPosition.getQuantity();
        }
        return overallQuantity;
    }

    /**
     * @return  The amount of money customer needs to pay to the Cashier
     */
    public double calculateOverallSum() {
        int overallSum = 0;
        for (ProductPosition productPosition: productPositions) {
            overallSum += productPosition.calculateSum();
        }
        return overallSum;
    }

    /**
     * Checks if there are such products in the supermarket
     * @param products  positions to check for availability to sell
     * @return          true if we are able to sell such products, false otherwise
     */
    public boolean checkAvailability(ArrayList<ProductPosition> products) {
        for (ProductPosition product : products) {
            if (!productPositions.contains(product)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if there are such product in the supermarket
     * @param product   position to check for availability to sell
     * @return          true if we are able to sell this product, false otherwise
     */
    public boolean checkAvailability(ProductPosition product) {
        return productPositions.contains(product);
    }
}
