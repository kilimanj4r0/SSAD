import customer.Customer;
import decorators.productdecorators.EveningDiscount;
import shopelements.CashRegister;
import shopelements.ShoppingCart;
import shopelements.ProductPosition;

import java.util.ArrayList;

public class Main {
    public static void printProductList(ArrayList<ProductPosition> array) {
        for (ProductPosition productPosition : array) {
            System.out.println("Id, Name, Price, Quantity: "
                    + productPosition.product.getId() + ", "
                    + productPosition.product.getProductName() + ", "
                    + productPosition.product.getPrice() + ", "
                    + productPosition.quantity);
        }
    }

    public static void main(String[] args) {
        CashRegister cashRegister = new CashRegister();
        String[] nameProducts = new String[]{"Pot", "Arrow", "Stockings"};
        double[] pricesProducts = new double[]{123, 344, 23};


        for (int i = 0; i < nameProducts.length; i++) {
            cashRegister.addProduct(nameProducts[i], pricesProducts[i], 1);
        }

        cashRegister.addProduct("bulka", 50, 1);

        cashRegister.getProductList().get(cashRegister.getProductList().size() - 1).product = new EveningDiscount(cashRegister.getProductList().get(cashRegister.getProductList().size() - 1).product);

        Customer client = new Customer(new ShoppingCart());
        client.name = "Sirojiddin Komolov";

        printProductList(cashRegister.getProductList());

        client.shoppingCart.addProduct(cashRegister.getProduct(1, 1));
        client.shoppingCart.addProduct(cashRegister.getProduct(1, 14));
        client.shoppingCart.addProduct(cashRegister.getProduct(4, 1));

        client.shoppingCart.createOrder(cashRegister);
    }
}
