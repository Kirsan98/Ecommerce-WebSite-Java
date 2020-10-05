package main.java.ao;

public class CommandLine {
	private int quantity ; 
	private int price ;
	
	public CommandLine(int quantity, int price) {
		super();
		this.quantity = quantity;
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public int getPrice() {
		return price;
	} 
	
}
