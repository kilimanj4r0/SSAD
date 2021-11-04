package decorators.productdecorators;

import shopelements.Product;

public class EveningDiscount extends DiscountDecorator {
    public EveningDiscount(Product target) {
        super(target);
    }

    @Override
    public Product makeClone() {
        return new EveningDiscount(wrapee);
    }

    @Override
    public double getPrice() {
        return super.getPrice() * 0.8;
    }
}
