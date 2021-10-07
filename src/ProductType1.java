import static java.lang.System.exit;

/**
 *
 */
public class ProductType1 extends AbstractProduct {
    private static String secretKey;
    private int id;
    private String name;
    private double price;

    public ProductType1(ProductType1 target){
        super(target);
        if(target != null){
            this.id = target.id;
            this.name = target.name;
            this.price = target.price;
        }
        else {
            exit(0);
        }
    }
    @Override
    public AbstractProduct makeClone() {
        return new ProductType1(this);
    }

    @Override
    public String getProductName() {
        return name;
    }

    @Override
    public double getProductPrice() {
        return price;
    }

    @Override
    public void setName(String key, String name) {
        if (key.equals(secretKey)){
            this.name = name;
        }
        else {
            System.out.println("Access denied");
        }
    }

    @Override
    public void setPrice(String key, double price) {
        if(key.equals(secretKey)){
            this.price = price;
        }
        else{
            System.out.println("Access denied");
        }
    }
}
