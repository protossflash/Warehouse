//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Iterator;
//import java.util.StringTokenizer;
import java.util.*;
import java.text.*;
import java.io.*;

public class UserInterface {
    private static final int HELP                = 0,
                             ADD_CLIENT          = 1,
                             ADD_PRODUCTS        = 2,
                             ADD_SUPPLIER        = 3,
                             ADD_SUPPLIERPRODUCT = 4,                             
                             LIST_CLIENTS        = 5,                             
                             LIST_PRODUCTS       = 6,
                             LIST_SUPPLIERS      = 7, 
                             LIST_SUPPLIERPRODUCT= 8,
                             SAVE                = 9,
                             EXIT                = 10;

    private static UserInterface ui;
    private BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
    private static Warehouse warehouse;

    private UserInterface() {
        if (response("Load saved session?")) {
            retrieve();
        }
        else {
            warehouse = Warehouse.instance();
        }
    }

    public static UserInterface instance() {
        if (ui == null) {
            return ui = new UserInterface();
        }
        else {
            return ui;
        }
    }

    private boolean response(String prompt) {
        String next = getToken(prompt + " (y/n)");
        return (next.charAt(0) == 'y' || next.charAt(0) == 'Y');
    }

    private String getToken(String prompt) {
        do {
            try {
                System.out.println(prompt);

                String line = reader.readLine();
                StringTokenizer tokenizer = new StringTokenizer(line, "\n\r\f");

                if (tokenizer.hasMoreTokens()) {
                    return tokenizer.nextToken();
                }
            }
            catch (IOException ioe) {
                System.exit(0);
            }
        } while (true);
    }

    private int getCommand() {
        do {
            try {
                int value = Integer.parseInt((getToken("\nType " + HELP
                        + " for help. Enter command: ")));
                if (value <= EXIT && value >= HELP) {
                    return value;
                }
            }
            catch (NumberFormatException nfe) {
                System.out.println("Command must be a number.");
            }
        } while (true);
    }

    private void process() {
        int command;
        help();

        while ((command = getCommand()) != EXIT) {
            switch (command) {
                case HELP:
                    help();
                    break;

                case ADD_CLIENT:
                    addClient();
                    break;

                case ADD_PRODUCTS:
                    addProducts();
                    break;
                    
                case ADD_SUPPLIER:
                    addSupplier();
                    break;
                    
           //     case ADD_SUPPLIERPRODUCT:
           //         addSupplierProduct();
           //         break;
                    
                case LIST_CLIENTS:
                    listClients();
                    break;

                case LIST_PRODUCTS:
                    listProducts();
                    break;
                    
                case LIST_SUPPLIERS:
                    listSuppliers();
                    break;
                    
                case LIST_SUPPLIERPRODUCT:
                    listSupplierProduct();
                    break;

                case SAVE:
                    save();
                    break;
                
            }
        }

        System.out.println("Exiting...");
    }

    // Commands:
    private void help() {
        String message = "Commands are:\n"
                + "[ " + HELP + " ] for help\n"
                + "[ " + ADD_CLIENT + " ] to add clients\n"              
                + "[ " + ADD_PRODUCTS + " ] to add products\n"
                + "[ " + ADD_SUPPLIER + " ] to add supplier\n"
                + "[ " + ADD_SUPPLIERPRODUCT + " ] to add supplierproducts\n"
                + "[ " + LIST_CLIENTS + " ] to list clients\n"                
                + "[ " + LIST_PRODUCTS + " ] to list products\n"
                + "[ " + LIST_SUPPLIERS + " ] to list suppliers\n"   
                + "[ " + LIST_SUPPLIERPRODUCT + " ] to list supplierproducts\n"                  
                + "[ " + SAVE + " ] to save data\n"
                + "[ " + EXIT + " ] to exit\n";
                

        System.out.println(message);
    }

    private void addClient() {
		  String name = getToken("Enter client name");
      String address = getToken("Enter address");
      String phone = getToken("Enter phone");
        Client client = warehouse.addClient(name, address, phone);
        if (client == null) {
            System.out.println("Could not add client.");
        }
        else {
            System.out.println("Added: " + client);
        }
    }

    private void addProducts() {
			Product prod;
			boolean addMore = false;
//			do{
				String name = getToken("Enter product name");
				String quantity = getToken("Enter product quantity");
				String prodPrice = getToken("Enter product price");
				int amt = Integer.parseInt(quantity);
				double price = Double.parseDouble(prodPrice);
				System.out.println(name + amt + price);
/*				prod = Warehouse.addProduct(name, amt, price);
				if(prod != null){
					System.out.println(prod);
				} else {
					System.out.println("Product could not be added");
				}
				System.out.println("Add more products?");
				String more = getToken("(Y|y)[es] or anything else for no");
				addMore = (more.charAt(0) == 'y' || more.charAt(0) == 'Y');
			}while(addMore);
		}
/*        String input = "";
        Product product = null;
        int pid = -1;
        int count = 0;

        System.out.println("[ enter product id; " +
                "enter on a blank line to finish adding products ]");
        do {
            try {
                // Read pid and add to list.
                input = reader.readLine();
                pid = Integer.parseInt(input);
                product = warehouse.addProduct(pid);
            }
            catch (NumberFormatException nfe) {
                // Pid was not a number.
                System.out.println("Not a number");
                pid = -1;
            }
            catch (Exception e) {
                // Some unknown error from BufferedReader.
                e.printStackTrace();
                System.exit(1);
            }

            if (input == null || pid < 0) {
                // End of entry or invalid entry.
                break;
            }

            if (product == null) {
                // Product was not added.
                System.out.println("Could not add product");
            }
            else {
                // Product was added.
                System.out.println("Added [ " + product + " ]");
                ++count;
            }
        } while (true);
        System.out.println("Added [ " + count + " ] products");
				*/
    }
    
    private void addSupplier() {
      String name = getToken("Enter supplier name");
      String address = getToken("Enter address");
      String phone = getToken("Enter phone");
        Supplier supplier = warehouse.addSupplier(name, address, phone);
        if (supplier == null) {
            System.out.println("Could not add supplier.");
        }
        else {
            System.out.println("Added: " + supplier);
        }
    }

/*
   private void addSupplierProduct() {
        int sid = 0;
        int pid = 0;
        double price = 0;

        // Validation flags.
        boolean f_sid = false;
        boolean f_pid = false;

        SupplierProduct supplierProduct;

        String[] tokens;
        tokens = new String[3];

        System.out.println("Enter [supplier id],[product id],[price]" +
                " (no spaces)");
        do {
            try {
                // Collect each parameter.
                tokens = reader.readLine().split(",", 5);

                sid = Integer.parseInt(tokens[0]);
                pid = Integer.parseInt(tokens[1]);
                price = Double.parseDouble(tokens[2]);
            }
            catch (NumberFormatException e) {
                sid = 0;
                pid = 0;
                price = 0;

                // Reset flags.
                f_sid = false;
                f_pid = false;

                System.out.println("Not a number:");
            }
            catch (Exception e) {
                // BufferedReader exception.
                e.printStackTrace();
            }

            // Find the supplier.
            Iterator s = warehouse.getSuppliers();
            while (s.hasNext()) {
                if (((Supplier) s.next()).getSupplierId() == sid) {
                    f_sid = true;
                    break;
                }
            }

            // Find the product.
            Iterator p = warehouse.getProducts();
            while (p.hasNext()) {
                if (((Product) p.next()).getProductId() == pid) {
                    f_pid = true;
                    break;
                }
            }

        } while (!f_sid || !f_pid || price < 0);
        // sid, pid, and price are valid now.
        supplierProduct = warehouse.addSupplierProduct(sid, pid, price);
        if (supplierProduct != null) {
            // Addition was successful.
            System.out.println("Added " + supplierProduct);
        }
        else {
            System.out.println("Could not add supplier");
        }
    }
*/
    private void listClients() {
        Iterator clients = warehouse.getClients();

        while (clients.hasNext()) {
            System.out.println(clients.next());
        }
    }

    private void listProducts() {
        Iterator products = warehouse.getProducts();

        while (products.hasNext()) {
            System.out.println(products.next());
        }
    }
    
    private void listSuppliers() {
        Iterator suppliers = warehouse.getSuppliers();

        while (suppliers.hasNext()) {
            System.out.println(suppliers.next());
        }
    }
    
    private void listSupplierProduct() {
        Iterator supplierProducts = warehouse.getSupplierProducts();

        while (supplierProducts.hasNext()) {
            System.out.println(supplierProducts.next());
        }
    }
    

    private void save() {
        if (warehouse.save()) {
            System.out.println("Warehouse saved to disk");
        }
        else {
            System.out.println("Could not save to disk");
        }
    }

    private void retrieve() {
        try {
            Warehouse tempWarehouse = Warehouse.retrieve();

            if (tempWarehouse != null) {
                System.out.println("Warehouse loaded from  disk");
                warehouse = tempWarehouse;
            }
            else {
                System.out.println("File not on disk; creating new file");
                warehouse = Warehouse.instance();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    // End commands.

    public static void main(String[] args) {
        UserInterface.instance().process();
    }
}
