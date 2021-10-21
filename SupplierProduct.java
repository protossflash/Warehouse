import java.io.Serializable;

public class SupplierProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	private int supplierId;
	private int productId;
	private double price;
		
	SupplierProduct(int supplierId, int productId, double price){
		this.supplierId = supplierId;
		this.productId = productId;
		this.price = price;
	}

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override 
	public String toString() {
		return("[ sid: " + supplierId
                + ", pid: " + productId +
                ", price: " + price + " ]");
	}
}

