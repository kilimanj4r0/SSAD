package decorators.productdecorators;

import shopelements.Product;

public class RottenSale extends SaleDecorator {
    public RottenSale(Product target) {
        super(target);
    }

    @Override
    public Product makeClone() {
        return null;
    }

    @Override
    public Product createProduct(int id, String name, double price, String key) {
        return null;
    }
}
