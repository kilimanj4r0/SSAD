public class ProductType1 extends AbstractProduct {
    private static String secretKey;
    private int id;
    private String name;
    private double price;

    @Override
    public AbstractProduct makeClone() {
        return null;
    }

    @Override
    public String getProductName() {
        return null;
    }

    @Override
    public double getProductPrice() {
        return 0;
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
