import java.io.Serializable;

public class ShoppingCartList implements Serializable{
    private static final long serialVersionUID = 1L;
    private Product product;
    private int quantity;

    private static ShoppingCartList shoppingcartlist;

    public ShoppingCartList(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    /*
    public static ShoppingCartList instance() {
        if (shoppingcartlist == null) {
            return (shoppingcartlist = new ShoppingCartList());
        }
        else {
            return shoppingcartlist;
        }
    }
*/

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int newQuantity) {
        quantity = newQuantity;
    }

    public boolean equals(String id) {
        return this.product.equals(id);
    }
/*
    private void readObject(java.io.ObjectInputStream inputStream) {
        try {
            if (shoppingcartlist != null) {
                return;
            }
            else {
                inputStream.defaultReadObject();
                if (shoppingcartlist == null) {
                    shoppingcartlist = (shoppingcartlist) inputStream.readObject();
                }
                else {
                    inputStream.readObject();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
*/
    public String toString() {
        return "Product: " + product.toString() + ", Quantity: " + quantity;
    }
}