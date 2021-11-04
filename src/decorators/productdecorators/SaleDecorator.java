package decorators.productdecorators;

import shopelements.Product;

public abstract class SaleDecorator extends Product {
    public SaleDecorator(Product target) {
        super(target);
    }
}
