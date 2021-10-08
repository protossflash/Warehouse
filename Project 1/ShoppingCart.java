import java.util.*;
import java.io.*;

public class ShoppingCart implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<ShoppingCartItem> cart;

    public ShoppingCart() {
        cart = new LinkedList<ShoppingCartItem>();
    }

    // insert a product into the shopping cart and the quantity
    public boolean insertProductToCart(Product product, int quantity) {
        ShoppingCartItem item = new ShoppingCartItem(product, quantity);
        cart.add(item);
        return true;
    }

    public Iterator<ShoppingCartItem> getShoppingCartProducts() {
        return cart.iterator();
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        Iterator<ShoppingCartItem> cartIterator = cart.iterator();

        while (cartIterator.hasNext()){
            ShoppingCartItem item = cartIterator.next();
            totalPrice += (item.getProduct().getSalePrice() * item.getQuantity());
        }

        return totalPrice;
    }

    public String toString() {
        return cart.toString();
    }
}








    import java.util.*;
        import java.lang.*;
        import java.io.*;

public class ShoppingCart implements Serializable {
    private static final long serialVersionUID = 1L;
    private List cart = new LinkedList();
    private static ShoppingCart cartList;

    public ShoppingCart() {
    }

    /*
    public boolean addCart(Product product, int quantity)
    {
        cart.add(product, quantity);
        return true;
    }
    */
    public Iterator getCart()
    {
        return cart.iterator();
    }

    //Get total
    /*
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
     */

    public String toString() {
        return cart.toString();
    }

    public static void main(String[] args)
    {
        System.out.println("Testing ShoppingCart.java");
        Product testp = new Product("1304", "Bestbuy Hammer", 20,10.00);
        ProductList testpl = new ProductList();
        testpl.insertProduct(testp);
        System.out.println(testpl.toString());
    }

}