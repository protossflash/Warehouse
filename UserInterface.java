import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;


public class UserInterface {
    private static final int HELP           = 0,
                             ADD_CLIENT     = 1,
                             ADD_PRODUCTS   = 2,                      
                             LIST_CLIENTS   = 3,                             
                             LIST_PRODUCTS  = 4,
                             SAVE           = 5,
                             EXIT           = 6;

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
            catch (Exception e) {
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
            catch (Exception e) {
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

                case LIST_CLIENTS:
                    listClients();
                    break;

                case LIST_PRODUCTS:
                    listProducts();
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
                + "[ " + LIST_CLIENTS + " ] to list clients\n"                
                + "[ " + LIST_PRODUCTS + " ] to list products\n"
                + "[ " + SAVE + " ] to save data\n"
                + "[ " + EXIT + " ] to exit\n";
                

        System.out.println(message);
    }

    private void addClient() {
        Client client = warehouse.addClient();
        if (client == null) {
            System.out.println("Could not add client.");
        }
        else {
            System.out.println("Added: " + client);
        }
    }

    private void addProducts() {
        String input = "";
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
    }

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

    public static void main(String args[]) {
        UserInterface.instance().process();
    }
}
