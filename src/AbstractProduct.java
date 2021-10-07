public abstract class AbstractProduct {
    private String secretKey;
    private Integer id;
    private String name;
    private Double price;

    abstract AbstractProduct makeClone();
    abstract Pair<String, Double> getProduct();
    abstract void setName(Pair<String, String> assign);
    abstract void setPrice(Pair<String, Double> assign);
}
