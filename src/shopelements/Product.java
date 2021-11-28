package shopelements;

public interface Product {
    Product makeClone();
    String getName();
    void setName(String key, String name);
    double getPrice();
    void setPrice(String key, double price);
    int getId();
}
