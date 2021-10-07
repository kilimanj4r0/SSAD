public abstract class AbstractProduct {
    private static String secretKey;
    private int id;
    private String name;
    private double price;

    abstract public AbstractProduct makeClone();
    abstract public String getProductName();
    abstract public double getProductPrice();
    abstract public void setName(String key, String name);
    abstract public void setPrice(String key, double price);
}
