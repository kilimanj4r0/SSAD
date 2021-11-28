package decorators.productdecorators;

import shopelements.Product;

public class ExpiredDiscount extends DiscountDecorator {
    public ExpiredDiscount(Product target) {
        super(target);
    }

    @Override
    public Product makeClone() {
        return new ExpiredDiscount(wrappee);
    }

    @Override
    public double getPrice() {
        return super.getPrice() * 0.5;
    }
}
