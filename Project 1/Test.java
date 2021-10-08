import java.math.BigDecimal;
import java.util.*;
import java.text.*;
import java.io.*;

public class Test implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final int PRODUCT_NOT_FOUND  = 1;
    public static final int NO_SUCH_SUPPLIER  = 2;
    public static final int OPERATION_COMPLETED= 3;
    public static final int OPERATION_FAILED= 4;
    public static final int NO_SUCH_MEMBER = 5;
    private Client client;
    private ClientList clientList;
    private Product product;
    private ProductList productList;
    private Supplier supplier;
    private SupplierList supplierList;

    public static void main(String[] args){


        //Testing Client
        System.out.println("Testing ClientList.java and Client.java classes");
        Client testClient = new Client("Chase", "774 Avenue Lane", "643-327-2722");
        ClientList testClientList = new ClientList();
        testClientList.insertClient(testClient);
        System.out.print("Here is a test example of my code storing a client, putting that client in a client list and dispalying the client " +
                "information from the client list\n\n");
        System.out.println(testClientList.toString());
        System.out.println("\n");



        //Testing Product
        System.out.println("Testing ProductList.java and Product.java classes");
        Product testp = new Product("1304", "Bestbuy Hammer", 20,10.00);
        ProductList testpl = new ProductList();
        testpl.insertProduct(testp);
        System.out.println(testpl.toString());
        System.out.println("\n");

        //Testing Supplier
        Supplier test0 = new Supplier("Things & Stuff", "1234 Warehouse Road", "6892134765");
        Supplier test1 = new Supplier("whoops", "9823 North Road", "8023476509");
        Supplier test2 = new Supplier("Uuuhhhhh", "8735 East Road", "3934082567");
        Supplier test3 = new Supplier("Food is good", "9834 South Road", "9238045364");
        Supplier test4 = new Supplier("Whosimawhatsits", "3284 West Road", "8934052167");
        Supplier test5 = new Supplier("Chicken Nuggets", "2837 Circle Road", "8934280576");
        Supplier test6 = new Supplier("Party Time", "2139 Square Road", "9023428675");
        SupplierList testList = new SupplierList();
        testList.insertSupplier(test0);
        testList.insertSupplier(test1);
        testList.insertSupplier(test2);
        testList.insertSupplier(test3);
        testList.insertSupplier(test4);
        testList.insertSupplier(test5);
        testList.insertSupplier(test6);
        System.out.println("This is an automated test of the Supplier and SupplierList classes\n" + testList.toString());
        System.out.println("\n");

        //Testing Transaction
        Transaction testTransaction = new Transaction(new Date(), "This is a test Transaction", BigDecimal.TEN);
        System.out.print("\nHere is a test example of a test transaction and it's attributes (date, descprition and dollar amount)\n");
        System.out.println(testTransaction.toString());
    }

}