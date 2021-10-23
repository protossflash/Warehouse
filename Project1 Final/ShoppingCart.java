import java.util.*;
import java.io.*;

public class ShoppingCart implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<ShoppingCartList> shopcart = new LinkedList<>();
    private static ShoppingCart shoppingcart;
    private String product;
    private int quantity;

    /*
    public ShoppingCart(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
*/
    /*
    public boolean addItem(ShoppingCartList i) {
        ShoppingCartList item = new ShoppingCartList(product, quantity);
        shopcart.add(item);
        return shopcart.add(i);
    }
*/
    public Iterator<ShoppingCartList> getShoppingCart() {
        return shopcart.iterator();
    }

    public double getTotal() {
        double total = 0;
        Iterator<ShoppingCartList> cartIterator = shopcart.iterator();
        while (cartIterator.hasNext()){
            ShoppingCartList item = cartIterator.next();
            total += (item.getProduct().getPrice() * item.getQuantity());
        }
        return total;
    }

    public String toString() {
        return shopcart.toString();
    }
}