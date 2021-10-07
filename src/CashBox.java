import java.util.ArrayList;

public class CashBox {
    private static String secretKey;
    private int id;
    private ArrayList<ProductPosition> productPositions;

    public ArrayList<ProductPosition> getProductList() {
        return productPositions;
    }

    public void removeProduct(int id) {
        productPositions.remove(id); // TODO: Add checks
    }

    public void addProduct(ProductPosition productPosition) {
        productPositions.add(productPosition); // TODO: Add checks
    }

    public int calculateQuantityOfProducts() {
        int overallQuantity = 0;
        for (ProductPosition productPosition: productPositions) {
            overallQuantity += productPosition.getQuantity();
        }
        return overallQuantity;
    }

    public double calculateOverallSum() {
        int overallSum = 0;
        for (ProductPosition productPosition: productPositions) {
            overallSum += productPosition.calculateSum();
        }
        return overallSum;
    }

    public boolean checkAvailability() {
        return true;
    }
}
