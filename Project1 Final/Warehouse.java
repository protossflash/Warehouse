import java.io.*;
import java.util.Iterator;

public class Warehouse implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final String DATA_FILE = "WarehouseData";

    private ClientList clientList;
    private ProductList productList;
    private ShoppingCart shoppingcart;
    private WaitList waitlist;
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
    public Client addClient(String name, String address, String phone) {
        Client client = new Client(name, address, phone);

        if (clientList.addClient(client)) {
            return client;
        }

        return null;
    }

    public Product addProduct(String prodName, int amt, double price) {
        Product product = new Product(prodName, amt, price);

        if (productList.addProduct(product)) {
            return product;
        }

        return null;
    }
    
    public Supplier addSupplier(String name, String address, String phone) {
    	Supplier supplier = new Supplier(name, address, phone);

        if (supplierList.addSupplier(supplier)) {
            return supplier;
        }

        return null;
    }
/*
    public ShoppingCart addItem(String productid, int quantity){
        ShoppingCart cart = new ShoppingCart(productid, quantity);

        if(ShoppingCartList.addItem(ShoppingCart)) {
            return cart;
        }
        return null;
    }

    public Iterator<ShoppingCart> getShoppingcart(){
        return shoppingcart.getShoppingCart();
    }
*/
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

