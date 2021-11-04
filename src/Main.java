import shopelements.Cashbox;
import customer.Customer;
import shopelements.*;

import java.util.ArrayList;

public class Main {
    public static void printProductList(ArrayList<ProductPosition> array) {
        for (ProductPosition productPosition : array) {
            System.out.println("Id, Name, Price, Quantity: "
                    + productPosition.product.getId() + ", "
                    + productPosition.product.getProductName() + ", "
                    + productPosition.product.getProductPrice() + ", "
                    + productPosition.quantity);
        }
    }

    public static void main(String[] args) {
        Cashbox cashbox = new Cashbox();
        String[] nameProducts = new String[]{"Pot", "Arrow", "Stockings"};
        double[] pricesProducts = new double[]{123, 344, 23};


        for (int i = 0; i < nameProducts.length; i++) {
            Product a = Product.createProduct(nameProducts[i], pricesProducts[i], "");
            cashbox.addProduct(new ProductPosition(a, 1));
        }

        Customer client = new Customer(new ProductCart());
        client.name = "Sirojiddin Komolov";

        printProductList(cashbox.getProductList());

        client.productCart.addProduct(cashbox.getProduct(1, 2));
        client.productCart.addProduct(cashbox.getProduct(1, 14));

        client.productCart.createOrder(cashbox);
    }
}
