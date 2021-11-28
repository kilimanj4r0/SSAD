package shopelements;

import static java.lang.System.exit;

public class DefaultProduct implements Product {
    private static final String secretKey = "QWE123321";
    public static int nextId = 1;

    protected int id;
    protected String name;
    private double price;

    /**
     * Constructor
     *
     * @param name  name of the product
     * @param price price of the product
     */
    private DefaultProduct(String name, double price) {
        this.id = nextId;
        nextId++;
        this.name = name;
        this.price = price;
    }

    /**
     * Copy constructor
     *
     * @param target The object of type DefaultProduct that will be copied to the new one
     */
    protected DefaultProduct(DefaultProduct target) {
        if (target == null) {
            System.out.println("Null product occurred");
            exit(-1);
        }
        this.price = target.price;
        this.id = target.id;
        this.name = target.name;
    }

    /**
     * Function for creating the product via checking the key
     *
     * @param name  name of the product
     * @param price price of the product
     * @param key   key to get/not get access to the creation of the product
     * @return product in case of succeed, null otherwise
     */
    public static DefaultProduct createProduct(String name, double price, String key) {
        if (!secretKey.equals(key)) {
            System.out.println("You can not create product. Wrong key.");
            return null;
        }
        return new DefaultProduct(name, price);
    }

    public DefaultProduct makeClone() {
        return new DefaultProduct(this);
    }

    public String getName() {
        return name;
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

    public double getPrice() {
        return this.price;
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

    public int getId() {
        return this.id;
    }
}
