import static java.lang.System.exit;

/** The prototype for our products. */
public abstract class AbstractProduct {
    protected static String secretKey;
    protected int id;
    protected String name;
    protected double price;

    abstract public AbstractProduct makeClone();
    abstract public AbstractProduct createProduct(int id, String name, double price, String key);

    /**
     * Constructor
     * @param name  name of the product
     * @param price price of the product
     */
    protected AbstractProduct(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    /**
     * Copy constructor
     * @param target The object of type AbstractProduct that will be copied to the new one
     */
    public AbstractProduct(AbstractProduct target) {
        if(target == null){
            System.out.println("Null product occurred");
            exit(-1);
        }
        this.price = target.price;
        this.id = target.id;
        this.name = target.name;
    }

    public String getProductName() {
        return name;
    }

    public double getProductPrice() {
        return price;
    }

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
