package decorators.productdecorators;

import shopelements.Product;

public abstract class DiscountDecorator implements Product {
    protected Product wrapee;

    public DiscountDecorator(Product target) {
        wrapee = target;
    }

    abstract public Product makeClone();

    public String getName() {
        return wrapee.getName();
    }

    public void setName(String key, String name) {
        wrapee.setName(key, name);
    }

    public double getPrice() {
        return wrapee.getPrice();
    }

    public void setPrice(String key, double price) {
        wrapee.setPrice(key, price);
    }

    public int getId() {
        return wrapee.getId();
    }
}
