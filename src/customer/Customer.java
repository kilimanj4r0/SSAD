package customer;

import shopelements.ShoppingCart;

/**
 * Class representing the customer of the supermarket. We fill cart by calling shoppingCart's methods via particular
 * customer (one customer - one cart)
 */
public class Customer {
    public String name;
    public ShoppingCart shoppingCart;

    public Customer(ShoppingCart cart) {
        this.shoppingCart = cart;
    }
}
