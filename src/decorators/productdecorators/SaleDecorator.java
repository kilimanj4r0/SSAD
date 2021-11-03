package decorators.productdecorators;

import shopelements.Product;

public abstract class SaleDecorator {
    protected Product wrapee;

    public SaleDecorator(Product target) {
        wrapee = target;
    }

    public Product makeClone() {
        return wrapee.makeClone();
    }

    public String getProductName() {
        return wrapee.getProductName();
    }

    public double getProductPrice() {
        return wrapee.getProductPrice();
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
