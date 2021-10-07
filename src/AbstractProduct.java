import static java.lang.System.exit;

/**
 * Prototype for our products
 */
public abstract class AbstractProduct {
    public static int nextId = 1;
    protected static String secretKey;
    protected int id;
    protected String name;
    protected double price;

    /**
     * Copy constructor
     *
     * @param target The object of type AbstractProduct that will be copied to the new one
     */
    public AbstractProduct(AbstractProduct target) {
        if (target == null) {
            System.out.println("Null product occurred");
            exit(-1);
        }
        this.price = target.price;
        this.id = target.id;
        this.name = target.name;
    }

    /**
     * Constructor
     *
     * @param name  name of the product
     * @param price price of the product
     */
    protected AbstractProduct(String name, double price) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.price = price;
    }

    /**
     * Clones the object
     *
     * @return clone of the AbstractProduct
     */
    abstract public AbstractProduct makeClone();

    /**
     * Function for creating the product via checking the key
     *
     * @param name  name of the product
     * @param price price of the product
     * @param key   key to get/not get access to the creation of the product
     * @return product in case of succeed, null otherwise
     */
    abstract public AbstractProduct createProduct(int id, String name, double price, String key);

    public String getProductName() {
        return name;
    }

    public double getProductPrice() {
        return price;
    }

    /**
     * Sets name to the product via checking the key
     *
     * @param key  key to get/not get access to modifying the name
     * @param name new name
     */
    public void setName(String key, String name) {
        if (key.equals(secretKey)) {
            this.name = name;
        } else {
            System.out.println("Access denied");
        }
    }

    /**
     * Sets price to the product via checking the key
     *
     * @param key   key to get/not get access to modifying the price
     * @param price new price
     */
    public void setPrice(String key, double price) {
        if (key.equals(secretKey)) {
            this.price = price;
        } else {
            System.out.println("Access denied");
        }
    }
}
