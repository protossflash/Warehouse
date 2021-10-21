import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SupplierProductList implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<SupplierProduct> supplierProducts = new LinkedList<>();
    private static SupplierProductList supplierProductList;

    private SupplierProductList() {
        // Empty constructor.
    }

    public static SupplierProductList instance() {
        if (supplierProductList == null) {
            return (supplierProductList = new SupplierProductList());
        }
        else {
            return supplierProductList;
        }
    }

    public boolean addSupplierProduct(SupplierProduct supplierProduct) {
        boolean canAdd = true;
        SupplierProduct temp = null;

        // Make sure supplier does not already exist.
        Iterator i = getSupplierProducts();
        while (i.hasNext()) {
            temp = (SupplierProduct) i.next();

            // Check to see if supplier already exists.
            if (temp.getSupplierId() == supplierProduct.getSupplierId() &&
                    temp.getProductId() == supplierProduct.getProductId()) {
                canAdd = false;
                break;
            }
        }

        if (canAdd) {
            // Capture result of entry into list.
            canAdd = supplierProducts.add(supplierProduct);
        }

        return canAdd;
    }

    public Iterator<SupplierProduct> getSupplierProducts() {
        return supplierProducts.iterator();
    }

    private void writeObject(java.io.ObjectOutputStream outputStream) {
        try {
            outputStream.defaultWriteObject();
            outputStream.writeObject(supplierProductList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject(java.io.ObjectInputStream inputStream) {
        try {
            if (supplierProductList != null) {
                return;
            }
            else {
                inputStream.defaultReadObject();
                if (supplierProductList == null) {
                    supplierProductList = (SupplierProductList) inputStream.readObject();
                }
                else {
                    inputStream.readObject();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
