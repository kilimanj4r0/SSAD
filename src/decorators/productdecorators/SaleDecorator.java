package decorators.productdecorators;

import shopelements.Product;

public abstract class SaleDecorator extends Product {
    protected Product wrapee;

    public SaleDecorator(Product target) {
        super(target);
        wrapee = target;
    }

    abstract public Product makeClone();

    public String getProductName() {
        return wrapee.getProductName();
    }

    public void setName(String key, String name) {
        wrapee.setName(key, name);
    }

    public void setPrice(String key, double price) {
        wrapee.setPrice(key, price);
    }

    public int getId() {
        return wrapee.getId();
    }

    public double getPrice() {
        return wrapee.getPrice();
    }
}
