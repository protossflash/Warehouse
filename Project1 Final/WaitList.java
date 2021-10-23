import java.io.*;
import java.lang.*;

public class WaitList implements Serializable {
    private static final long serialVersionUID = 1L;
    private Product product;
    private Client client;
    private int quantity;

    public WaitList(Client client, Product product, int quantity){
        this.client   = client;
        this.product  = product;
        this.quantity = quantity;
    }

    public Client getClient() {
        return client;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }


    public String toString() {
        return ("Client: " + client + " Product: " + product + " Amount: " + quantity);
    }
}