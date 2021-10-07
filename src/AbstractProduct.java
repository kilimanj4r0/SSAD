import static java.lang.System.exit;

/**
 *  Prototype for our products
 */
public abstract class AbstractProduct {
    protected static String secretKey;
    protected int id;
    protected String name;
    protected double price;
    public static int next_id = 1;

    protected AbstractProduct(String name, double price){
        this.id = next_id;
        next_id++;
        this.name = name;
        this.price = price;
    }

    public AbstractProduct(AbstractProduct target) {
        if(target == null){
            System.out.println("Null product occurred");
            exit(-1);
        }
        this.price = target.price;
        this.id = target.id;
        this.name = target.name;
    }

    abstract public AbstractProduct makeClone();
    public String getProductName() {
        return name;
    }
    public double getProductPrice() {
        return price;
    }
    abstract public AbstractProduct createProduct(int id, String name, double price, String key);

    public void setName(String key, String name) {
        if (key.equals(secretKey)){
            this.name = name;
        }
        else {
            System.out.println("Access denied");
        }
    }


    public void setPrice(String key, double price) {
        if(key.equals(secretKey)){
            this.price = price;
        }
        else{
            System.out.println("Access denied");
        }
    }
}
