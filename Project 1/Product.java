import java.lang.*;
import java.io.*;

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    private String ID;
    private String name;
    private int quantity;
    private double prodPrice;

    public Product(String ID, String name, int quantity, double prodPrice)
    {
        this.ID = ID;
        this.name = name;
        this.quantity = quantity;
        this.prodPrice = prodPrice;
    }

    public String getProductID()
    {
        return ID;
    }

    public String getName()
    {
        return name;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public double getPrice()
    {
        return prodPrice;
    }

    public void setProductID(String newID)
    {
        ID = newID;
    }

    public void setName(String newname)
    {
        name = newname;
    }

    public void setQuantity(int newquantity)
    {
        quantity = newquantity;
    }

    public void setPrice(double newprodPrice)
    {
        prodPrice = newprodPrice;
    }

    public String toString()
    {
        return "Product ID: " + ID + " Name: " + name + " Quantity: " + quantity + " Price: " + prodPrice;
    }
    
}