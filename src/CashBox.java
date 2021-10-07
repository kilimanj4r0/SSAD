import java.util.ArrayList;

import static java.lang.System.exit;

public class CashBox {
    private static final String secretKey = "QWE123321";
    private int id;
    private ArrayList<ProductPosition> productPositions;


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

    public boolean checkAvailability(ArrayList<ProductPosition> products) {
        for (ProductPosition product : products) {
            if (!productPositions.contains(product)) {
                return false;
            }
        }
        return true;
    }
    public boolean checkAvailability(ProductPosition product) {
        if (!productPositions.contains(product)) {
            return false;
        }
        return true;
    }
}
