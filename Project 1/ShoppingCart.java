import java.util.*;
import java.lang.*;
import java.io.*;

public class ShoppingCart implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Product> Cart = new LinkedList<Product>();

    public ShoppingCart() {
    }


    public String getCartProductID(int pi)
    {
        return Cart.get(pi).getProductID();
    }

    public String getCartName(int n)
    {
        return Cart.get(n).getName();
    }

    public int getCartQuantity(int q)
    {
        return Cart.get(q).getQuantity();
    }

    public double getCartPrice(int p)
    {
        return Cart.get(p).getPrice();
    }

    /*
    Modify Shopping Cart(client ID, product ID, Quantity)

    public
     */


    /*
    Place an order(available product checked, waitlist, invoice)
    public void Order()
    {

    }
     */

    /*
    Query to check if product is in cart

    Query to check available Quantity for a product
     */

    //Get total
    /*
    public double getTotal() {

        return total;
    }
     */


    public Iterator getShoppingCart(){
        return Cart.iterator();
    }

    public String toString() {
        return Cart.toString();
    }


}