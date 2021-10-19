import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;

public class ProductList implements Serializable {
    private static final long serialVersionUID = 1L;

	private List<Product> products = new LinkedList<>();
    private static ProductList productList;

    //Constructor
    private ProductList() {}

    public static ProductList instance() {
        if (productList == null) {
            return (productList = new ProductList());
        }
        else {
            return productList;
        }
    }

    //Method to add a product to the list
    public boolean addProduct(Product p){
        boolean canAdd = true;

        // Make sure this product does not share a pid with another product.
        Iterator i = getProducts();
        while (i.hasNext()) {
            if (((Product) i.next()).getProductId() == p.getProductId()) {
                // A match was found.
                canAdd = false;
                break;
            }
        }

    	if (canAdd) {

            canAdd = products.add(p);
        }

        return canAdd;
    }
    

    public Iterator<Product> getProducts() {
        return products.iterator();
    }

    private void writeObject(java.io.ObjectOutputStream outputStream) {
        try {
            outputStream.defaultWriteObject();
            outputStream.writeObject(productList);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void readObject(java.io.ObjectInputStream inputStream) {
        try {
            if (productList != null) {
                return;
            }
            else {
                inputStream.defaultReadObject();
                if (productList == null) {
                    productList = (ProductList) inputStream.readObject();
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
    
    @Override
    public String toString(){
    	return products.toString();
    }
}
