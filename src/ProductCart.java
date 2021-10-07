import java.util.ArrayList;

import static java.lang.System.exit;

public class ProductCart {
    private ArrayList<ProductPosition> products;

    public ArrayList<ProductPosition> getProductList(){
        return products;
    }
    public void addProduct(ProductPosition productPosition){
        products.add(productPosition);
    }
    public void removeProduct(ProductPosition productPosition, int numOfRemoval){
        int temp = productPosition.getQuantity();
        if(numOfRemoval < temp){
            productPosition.setQuantity(temp - numOfRemoval);
        }
        else if( numOfRemoval == temp){
            products.remove(productPosition);
        }
        else{
            System.out.println("You are trying to remove more products than customer have in the cart");
            exit(-1);
        }
    }
    public void createOrder(){

    }
}
