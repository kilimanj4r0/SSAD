package decorators.productdecorators;

import shopelements.Product;

public abstract class DiscountDecorator implements Product {
    protected Product wrappee;

    public DiscountDecorator(Product target) {
        wrappee = target;
    }

    abstract public Product makeClone();

    public String getName() {
        return wrappee.getName();
    }

    public void setName(String key, String name) {
        wrappee.setName(key, name);
    }

    public double getPrice() {
        return wrappee.getPrice();
    }

    public void setPrice(String key, double price) {
        wrappee.setPrice(key, price);
    }

    public int getId() {
        return wrappee.getId();
    }
}
