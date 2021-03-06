import java.util.*;
import java.io.*;

public class Client implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String name;
    private String address;
    private String phone;
    private String id;
		private double balance;
    private static final String CLIENT_STRING = "C";
		
    private List<Product> shopCart = new LinkedList<Product>();
//    private List<Order> orders = new LinkedList<Order>();
//    private List<Invoice> invoices = new LinkedList<Invoice>();

    public Client(String name, String address, String phone)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        id = CLIENT_STRING + (ClientIdServer.instance()).getId();
    }

    public String getName()
    {
        return name;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getAddress()
    {
        return address;
    }

    public String getId()
    {
        return id;
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public void setAddress(String newAddress)
    {
        address = newAddress;
    }

    public void setPhone(String newPhone)
    {
        phone = newPhone;
    }

    public boolean equals(String id)
    {
        return this.id.equals(id);
    }

    public String toString()
    {
        String string = "Client name " + name + " address " + address + " id " + id + " phone " + phone + "\n";
        return string;
    }

}