import java.util.*;
import java.lang.*;
import java.io.*;

public class ShoppingCart implements Serializable {
    private static final long serialVersionUID = 1L;
    private List cart = new LinkedList();
    private static ShoppingCart cartList;

    public ShoppingCart() {
    }

    public boolean addCart(Product product, int quantity)
    {
        cart.add(product, quantity);
        return true;
    }

    public Iterator getCart()
    {
        return cart.iterator();
    }

    public double getTotal() {
        double total = 0;
        if(total = 0)
        {
            Iterator<cart> cartIterator = cart.iterator();
            while (cartIterator.hasNext()) {

                cart item = cartIterator.next();
                total += (item.getName().getPrice() * item.getQuantity());
            }
        }
        return total;
    }

    public String toString() {
        return cart.toString();
    }
}