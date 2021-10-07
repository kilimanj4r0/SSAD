import java.util.ArrayList;

public class Main {
    public static void printProductList(ArrayList<ProductPosition> array){
        for (ProductPosition productPosition : array) {
            System.out.println("Id, Name, Price, Number of product: "
                    + productPosition.product.id + ", "
                    + productPosition.product.name + ", "
                    + productPosition.product.price + ", "
                    + productPosition.quantity);
        }
    }

    public static void main(String[] args) {
        Cashbox cashBox = new Cashbox();
        String[] name_products = new String[]{"Pot", "Arrow", "Stockings"};
        double[] prices_products = new double[]{123, 344, 23};

        for (int i = 0; i < name_products.length; i++){
            cashBox.addProduct(new ProductPosition(new ProductType1(name_products[i], prices_products[i]), i + 2));
        }

        Customer client = new Customer(new ProductCart());
        client.name = "Sirojiddin Komolov";

        printProductList(cashBox.getProductList());

        client.productCart.addProduct(cashBox.getProduct(1, 2));
        client.productCart.addProduct(cashBox.getProduct(1, 14));

        client.productCart.createOrder(cashBox);
    }
}
