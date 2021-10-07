import java.util.ArrayList;

public class Main {
    public static void printProductList(ArrayList<ProductPosition> array) {
        for (ProductPosition productPosition : array) {
            System.out.println("Id, Name, Price, Number of product: "
                    + productPosition.product.id + ", "
                    + productPosition.product.name + ", "
                    + productPosition.product.price + ", "
                    + productPosition.quantity);
        }
    }

    public static void main(String[] args) {
        Cashbox cashbox = new Cashbox();
        String[] nameProducts = new String[]{"Pot", "Arrow", "Stockings"};
        double[] pricesProducts = new double[]{123, 344, 23};

        for (int i = 0; i < nameProducts.length; i++) {
            cashbox.addProduct(new ProductPosition(new ProductType1(nameProducts[i], pricesProducts[i]), i + 2));
        }

        Customer client = new Customer(new ProductCart());
        client.name = "Sirojiddin Komolov";

        printProductList(cashbox.getProductList());

        client.productCart.addProduct(cashbox.getProduct(1, 2));
        client.productCart.addProduct(cashbox.getProduct(1, 14));

        client.productCart.createOrder(cashbox);
    }
}
