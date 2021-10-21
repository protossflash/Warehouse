import java.io.*;
import java.util.Iterator;

public class Warehouse implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String DATA_FILE = "WarehouseData";

    private ClientList clientList;
    private ProductList productList;
    private SupplierList supplierList;
    private SupplierProductList supplierProductList;
    
    private static Warehouse warehouse;

    private Warehouse() {
        clientList = ClientList.instance();
       productList = ProductList.instance();
       supplierList = SupplierList.instance(); 
       supplierProductList = SupplierProductList.instance();       
    }

    public static Warehouse instance() {
        if (warehouse == null) {
            ClientIdServer.instance();
            return warehouse = new Warehouse();
        }
        else {
            return warehouse;
        }
    }

    // Add methods.
    public Client addClient() {
        Client client = new Client();

        if (clientList.addClient(client)) {
            return client;
        }

        return null;
    }

    public Product addProduct(int pid) {
        Product product = new Product(pid);

        if (productList.addProduct(product)) {
            return product;
        }

        return null;
    }
    
    public Supplier addSupplier(int sid) {
    	Supplier supplier = new Supplier(sid);

        if (supplierList.addSupplier(supplier)) {
            return supplier;
        }

        return null;
    }

    public SupplierProduct addSupplierProduct(int sid, int pid, double price) {
        SupplierProduct supplierProduct = new SupplierProduct(sid, pid, price);

        if (supplierProductList.addSupplierProduct(supplierProduct)) {
            return supplierProduct;
        }

        return null;
    }
    

    
    // End add methods.

    // Iterators.
    public Iterator<Client> getClients() {
        return clientList.getClients();
    }

    public Iterator<Product> getProducts() {
        return productList.getProducts();
    }

    public Iterator<Supplier> getSuppliers() {
        return supplierList.getSuppliers();
    }
    public Iterator<SupplierProduct> getSupplierProducts() {
        return supplierProductList.getSupplierProducts();
    }
    // End iterators.

    public static Warehouse retrieve() {
        try {
            FileInputStream file = new FileInputStream(DATA_FILE);
            ObjectInputStream inputStream = new ObjectInputStream(file);

            inputStream.readObject();
            ClientIdServer.retrieve(inputStream);

            return warehouse;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean save() {
        try {
            FileOutputStream file = new FileOutputStream(DATA_FILE);
            ObjectOutputStream outputStream = new ObjectOutputStream(file);

            outputStream.writeObject(warehouse);
            outputStream.writeObject(ClientIdServer.instance());

            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void writeObject(java.io.ObjectOutputStream outputStream) {
        try {
            outputStream.defaultWriteObject();
            outputStream.writeObject(warehouse);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject(java.io.ObjectInputStream inputStream) {
        try {
            inputStream.defaultReadObject();
            if (warehouse == null) {
                warehouse = (Warehouse) inputStream.readObject();
            }
            else {
                inputStream.readObject();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return clientList + "\n";
    }
}

