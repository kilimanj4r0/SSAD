import java.util.ArrayList;

public class CashBox {
    private static String secretKey;
    private int id;
    private ArrayList<ProductPosition> productPositions;

    public void removeProduct(int id) {

    }
    public void addProduct(ProductPosition productPosition) {

    }
    public ArrayList<ProductPosition> getProductList() {
        return productPositions;
    }
    public int calculateQuantityOfProducts() {
        return 0;
    }
    public double calculateOverallSum() {
        return 0.0;
    }
    public boolean checkAvailability() {
        return true;
    }
}
