import static java.lang.System.exit;

/**
 *
 */
public class ProductType1 extends AbstractProduct {

    public ProductType1(ProductType1 target){
        super(target);
    }

    public ProductType1(String name, double price) {
        super(name, price);
    }

    @Override
    public AbstractProduct makeClone() {
        return new ProductType1(this);
    }

    @Override
    public AbstractProduct createProduct(int id, String name, double price, String key){
        if (secretKey.equals(key)){
            System.out.println("You can not create product. Wrong key.");
            return null;
        }
        return new ProductType1(name, price);
    }

}
