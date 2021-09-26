import java.util.*;
import java.io.*;
public class Supplier implements Serializable {
  private static final long serialVersionUID = 1L;
  private String name;
  private String address;
  private String phone;
  private String id;
  private static final String SUPPLIER_STRING = "M";
	
  public  Supplier (String name, String address, String phone) {
    this.name = name;
    this.address = address;
    this.phone = phone;
    id = SUPPLIER_STRING;
  }

  public String getName() {
    return name;
  }
  public String getPhone() {
    return phone;
  }
  public String getAddress() {
    return address;
  }
  public String getId() {
    return id;
  }
  public void setName(String newName) {
    name = newName;
  }
  public void setAddress(String newAddress) {
    address = newAddress;
  }
  public void setPhone(String newPhone) {
    phone = newPhone;
  }
  public boolean equals(String id) {
    return this.id.equals(id);
  }
  public String toString() {
    String string = "Supplier name: " + name + " address: " + address + " id: " + id + " phone: " + phone + "\n";
    return string;
  }
	
	public void createId(int sid){
		this.id = this.id + "12300" + sid;
	}
	
	public static void main(String[] args){
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
	}
	
}