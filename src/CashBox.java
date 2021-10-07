import java.util.ArrayList;

public class CashBox {
    private static String secretKey;
    private int id;
    private ArrayList<ProductPosition> productPositions;

<<<<<<< HEAD
    public void removeProduct(int id) {
        for (int i = 0; i < productPositions.size(); i++) {
            
        }
=======
    public ArrayList<ProductPosition> getProductList() {
        return productPositions;
>>>>>>> 51e48f7f57fd552d018ebc848156773e518554ad
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
