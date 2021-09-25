import java.util.*;
import java.io.*;

public class Client implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String name;
    private String address;
    private String phone;
    private String id;
    private static final String CLIENT_STRING = "C";

    public Client(String name, String address, String phone)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        id = CLIENT_STRING + generateRandomID();
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
        String string = "Client name " + name + " address " + address + " id " + id + "phone " + phone;
        return string;
    }

    public int generateRandomID()
    {
        Random r = new Random(System.currentTimeMillis());
        return 10000 + r.nextInt(20000);
    }

    //Here is some test code to show my two classes: Client and ClientList
    public static void main(String[] args)
    {
        Client testClient = new Client("Chase", "774 Avenue Lane", "643-327-2722");
        ClientList testClientList = new ClientList();
        testClientList.insertClient(testClient);
        System.out.print("Here is a test example of my code storing a client, putting that client in a client list and dispalying the client " +
                "information from the client list\n\n");
        System.out.println(testClientList.toString());
    }

}