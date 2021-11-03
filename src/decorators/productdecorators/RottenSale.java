package decorators.productdecorators;

import shopelements.Product;

public class RottenSale extends SaleDecorator {
    public RottenSale(Product target) {
        super(target);
    }

    @Override
    public double getPrice() {
        return super.getPrice() * 0.5;
    }
}
