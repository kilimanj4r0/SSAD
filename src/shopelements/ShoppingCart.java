package shopelements;

import java.util.ArrayList;

import static java.lang.System.exit;

/**
 * Class representing the pac.Product Cart in supermarket.
 * pac.Customer owns it and performs operation with products(addition or removal) through it
 */
public class ShoppingCart {
    private final ArrayList<ProductPosition> products = new ArrayList<ProductPosition>();

    /**
     * @return Returns ArrayList with all product positions in the cart
     */
    public ArrayList<ProductPosition> getProductList() {
        return products;
    }

    /**
     * Adds the product type in the cart in the cart, the number of products is hold inside the class pac.ProductPosition
     *
     * @param productPosition The product position that we put inside the cart
     */
    public void addProduct(ProductPosition productPosition) {
        if (productPosition != null) {
            int index = indexInCart(productPosition);
            if (index != -1) products.get(index).quantity += productPosition.quantity;
            else products.add(productPosition);
        }
    }

    /**
     * Removes certain amount of product of one type from the cart
     *
     * @param productPosition The product position that we need to take out of cart
     * @param numOfRemoval    Number of products that we take off
     */
    public void removeProduct(ProductPosition productPosition, int numOfRemoval) {
        int temp = productPosition.getQuantity();
        if (numOfRemoval < temp) {
            productPosition.setQuantity(temp - numOfRemoval);
        } else if (numOfRemoval == temp) {
            products.remove(productPosition);
        } else {
            System.out.println("You are trying to remove more products than customer have in the cart");
            exit(-1);
        }
    }


    /**
     * Passing the cart to the cashRegister (terminal), where it will be manipulated further
     */
    public void createOrder(CashRegister cashRegister) {
        if (cashRegister.checkAvailability(products)) {
            System.out.println("Your order:");
            for (ProductPosition productPosition : products) {
                if (cashRegister.getProduct(productPosition.product.id, productPosition.quantity) == null) {
                    productPosition.quantity = cashRegister.getProduct(productPosition.product.id, 0).quantity;
                }
                System.out.println("Id, Name, Price, Number of product: "
                        + productPosition.product.id + ", "
                        + productPosition.product.name + ", "
                        + productPosition.product.getPrice() + ", "
                        + productPosition.quantity);
                cashRegister.changeQuantity(productPosition.product.id, productPosition.quantity);
            }
            System.out.println("Total bill: " + cashRegister.calculateOverallSum(products));
            products.clear();
        } else {
            System.out.println("Some of these products are already unavailable.");
        }
    }

    /**
     * Checks if there are such for_search in the supermarket
     *
     * @param for_search position to check for availability to sell
     * @return true if we are able to sell this for_search, false otherwise
     */
    public int indexInCart(ProductPosition for_search) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).product == for_search.product) {
                return i;
            }
        }
        return -1;
    }
}
