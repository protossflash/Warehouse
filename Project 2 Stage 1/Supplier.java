import java.io.Serializable;

public class Supplier implements Serializable {
    private static final long serialVersionUID = 1L;

	private int supplierId;
	
	Supplier(int supplierId){
		this.supplierId = supplierId;
	}

	public int getSupplierId() {
	    return this.supplierId;
    }
	
	@Override
	public String toString() {
		return ("Supplier Id: " + supplierId );
	}
}
