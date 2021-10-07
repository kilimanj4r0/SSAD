import static java.lang.System.exit;

public abstract class AbstractProduct {
    public AbstractProduct(AbstractProduct target) {
        if(target == null){
            System.out.println("Null product occurred");
            exit(-1);
        }
    }

    abstract public AbstractProduct makeClone();
    abstract public String getProductName();
    abstract public double getProductPrice();
    abstract public void setName(String key, String name);
    abstract public void setPrice(String key, double price);
}
