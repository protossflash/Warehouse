import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

	private int productId;
	
	Product(int productId){
		this.productId = productId;
	}
	
	public int getProductId(){
		return productId;
	}
	
	@Override
	public String toString(){
		return ("Product ID: " + productId);
	}
}

