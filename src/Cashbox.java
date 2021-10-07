import java.util.ArrayList;
import static java.lang.System.exit;

/**
 * Class representing Cashier point in our supermarket
 * Can change the parameters of products passed to it by using special Cashier key (Galya otmena)
 */
public class Cashbox {
    private static final String SECRET_KEY = "QWE123321";
    private int id;
    private ArrayList<ProductPosition> productPositions;

    /** Returns an ArrayList of all products in our supermarket */
    public ArrayList<ProductPosition> getProductList() {
        return productPositions;
    }

    public void removeProduct(int id) {
        productPositions.remove(id); // TODO: Add checks
    }

    public void addProduct(ProductPosition productPosition) {
        ArrayList<ProductPosition> tmp_products = new ArrayList<>();
        tmp_products.add(productPosition);
        if (!checkAvailability(tmp_products)){
            System.out.println("Such product is not available");
            exit(-1);
        }
        productPositions.add(productPosition);
    }

    /** Returns the number of products in the order (bill) */
    public int calculateQuantityOfProducts() {
        int overallQuantity = 0;
        for (ProductPosition productPosition: productPositions) {
            overallQuantity += productPosition.getQuantity();
        }
        return overallQuantity;
    }

    /** Returns the amount of money customer needs to pay to the Cashier */
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
