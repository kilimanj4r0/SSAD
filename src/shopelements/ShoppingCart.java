package shopelements;

import iterators.ProductPositionDeleteIterator;

import java.util.ArrayList;

import static java.lang.System.exit;

/**
 * Class representing the pac. Product Cart in supermarket.
 * pac. Customer owns it and performs operation with products (addition or removal) through it.
 */
public class ShoppingCart extends ArrayList<ProductPosition> {
    /**
     * Adds the product type in the cart in the cart, the number of products is hold inside the class pac.ProductPosition
     *
     * @param productPosition The product position that we put inside the cart
     */
    @Override
    public boolean add(ProductPosition productPosition) {
        if (productPosition != null) {
            int index = indexInCart(productPosition);
            if (index != -1) this.get(index).quantity += productPosition.quantity;
            else super.add(productPosition);
            return true;
        }
        return false;
    }

    public boolean remove(ProductPosition productPosition, int numOfRemoval) {
        int temp = productPosition.getQuantity();
        if (numOfRemoval < temp) {
            productPosition.setQuantity(temp - numOfRemoval);
        } else if (numOfRemoval == temp) {
            super.remove(productPosition);
        } else {
            System.out.println("You are trying to remove more products than customer have in the cart");
            exit(-1);
        }
        return true;
    }

    /**
     * Passing the cart to the cashRegister (terminal), where it will be manipulated further
     */
    public void createOrder(CashRegister cashRegister) throws Exception {
        System.out.println("Your order:");
        ProductPositionDeleteIterator iterator = new ProductPositionDeleteIterator(this);
        ProductPosition productPosition = iterator.getNext();
        while (true) {
            if (cashRegister.getProduct(productPosition.product.getId(), productPosition.quantity) == null) {
                if (!iterator.hasNext()) {
                    this.remove(productPosition);
                    break;
                }
                productPosition = iterator.getNextAndDelete();
                continue;
            }
            System.out.println("Id, Name, Price, Number of product: "
                    + productPosition.product.getId() + ", "
                    + productPosition.product.getName() + ", "
                    + productPosition.product.getPrice() + ", "
                    + productPosition.quantity);
            cashRegister.changeQuantity(productPosition.product.getId(), -productPosition.quantity);

            if (!iterator.hasNext()) break;
            productPosition = iterator.getNext();
        }
        System.out.println("Total bill: " + cashRegister.calculateOverallSum(this));
        this.clear();
    }

    /**
     * Checks if there are such forSearch in the supermarket
     *
     * @param forSearch position to check for availability to sell
     * @return true if we are able to sell this forSearch, false otherwise
     */
    public int indexInCart(ProductPosition forSearch) {
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).product == forSearch.product) {
                return i;
            }
        }
        return -1;
    }
}
