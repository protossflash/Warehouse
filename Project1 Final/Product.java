import java.lang.*;
import java.io.*;

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private int quantity;
    private double prodPrice;
		private static final String PRODUCT_STRING = "P";

    public Product(String name, int quantity, double prodPrice)
    {
        id = PRODUCT_STRING + (ProductIdServer.instance()).getId();
        this.name = name;
        this.quantity = quantity;
        this.prodPrice = prodPrice;
    }

    public String getProductId()
    {
        return id;
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
		
		public boolean equals(String id) {
			return this.id.equals(id);
		}

    public String toString()
    {
        return "Product ID: " + id + " Name: " + name + " Quantity: " + quantity + " Price: " + prodPrice;
    }
    
}