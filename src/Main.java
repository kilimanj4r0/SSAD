import customer.Customer;
import decorators.productdecorators.EveningDiscount;
import shopelements.CashRegister;
import shopelements.ProductPosition;

import java.util.ArrayList;

public class Main {
    public static void printProductList(ArrayList<ProductPosition> array) {
        for (ProductPosition productPosition : array) {
            System.out.println("Id, Name, Price, Quantity: "
                    + productPosition.product.getId() + ", "
                    + productPosition.product.getName() + ", "
                    + productPosition.product.getPrice() + ", "
                    + productPosition.quantity);
        }
    }

    public static void main(String[] args) throws Exception {
        CashRegister cashRegister = new CashRegister();
        String[] nameProducts = new String[]{"Pot", "Arrow", "Stockings"};
        double[] pricesProducts = new double[]{123, 344, 23};


        for (int i = 0; i < nameProducts.length; i++) {
            cashRegister.addProduct(nameProducts[i], pricesProducts[i], 1);
        }

        cashRegister.addProduct("Bread", 50, 1);

        cashRegister.getProductList().get(cashRegister.getProductList().size() - 1).product = new EveningDiscount(cashRegister.getProductList().get(cashRegister.getProductList().size() - 1).product);

        Customer client = new Customer("Sirojiddin Komolov");

        printProductList(cashRegister.getProductList());

        client.shoppingCart.add(cashRegister.getProduct(1, 1));
        client.shoppingCart.add(cashRegister.getProduct(1, 14));
        client.shoppingCart.add(cashRegister.getProduct(4, 1));

        cashRegister.removeProduct(0);

        client.shoppingCart.createOrder(cashRegister);
    }
}
