package decorators.productdecorators;

import shopelements.Product;

public class EveningSale extends SaleDecorator {
    public EveningSale(Product target) {
        super(target);
    }

    @Override
    public double getPrice() {
        return super.getPrice() * 0.8;
    }
}
