package shopelements;

import java.util.ArrayList;

/**
 * Class representing Cashier point in our supermarket
 * Can change the parameters of products passed to it by using special Cashier key (Galya otmena)
 */
public class CashRegister {
    private static final String secretKey = "QWE123321";
    private final ArrayList<ProductPosition> productPositions = new ArrayList<ProductPosition>();

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
        int index = indexInCart(productPosition);
        if (index != -1) productPositions.get(index).quantity += 1;
        else productPositions.add(productPosition);
    }

    public void addProduct(String name, double price, int quantity) {
        Product product = Product.createProduct(name, price, secretKey);
        this.productPositions.add(new ProductPosition(product, quantity));
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
            if (!checkAvailability(product)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if there are such for_search in the supermarket
     *
     * @param for_search position to check for availability to sell
     * @return true if we are able to sell this for_search, false otherwise
     */
    public boolean checkAvailability(ProductPosition for_search) {
        for (ProductPosition pos : productPositions) {
            if (pos.product.id == for_search.product.id && pos.quantity >= for_search.quantity) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there are such for_search in the supermarket
     *
     * @param for_search position to check for availability to sell
     * @return true if we are able to sell this for_search, false otherwise
     */
    public int indexInCart(ProductPosition for_search) {
        for (int i = 0; i < productPositions.size(); i++) {
            if (productPositions.get(i).product == for_search.product) {
                return i;
            }
        }
        return -1;
    }
}
