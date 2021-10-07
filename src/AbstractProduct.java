public abstract class AbstractProduct {
    abstract public AbstractProduct makeClone();
    abstract public String getProductName();
    abstract public double getProductPrice();
    abstract public void setName(String key, String name);
    abstract public void setPrice(String key, double price);
}
