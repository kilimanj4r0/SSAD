package iterators;

import shopelements.ProductPosition;
import shopelements.ShoppingCart;

/**
 * Implementation of DeleteIterator interface for ProductPosition.
 */
public class ProductPositionDeleteIterator implements DeleteIterator<ProductPosition> {
    final private ShoppingCart cart;
    private int currentProductPositionIndex = -1;

    public ProductPositionDeleteIterator(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public boolean hasNext() {
        return currentProductPositionIndex < cart.size() - 1;
    }

    @Override
    public ProductPosition getNext() {
        currentProductPositionIndex += 1;
        return cart.get(currentProductPositionIndex);
    }

    @Override
    public ProductPosition getNextAndDelete() throws Exception {
        if (currentProductPositionIndex == -1) {
            throw new Exception();
        }
        cart.remove(currentProductPositionIndex);
        return cart.get(currentProductPositionIndex);
    }

    @Override
    public void reset() {
        currentProductPositionIndex = -1;
    }
}
