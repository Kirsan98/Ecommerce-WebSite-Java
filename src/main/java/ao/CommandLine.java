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

/* public class CommandLine {
	private Reference ref; 
	private int quantity ; 
	private int amount;

	private int id; 
	
	public CommandLine(int id, Reference ref,int quantity, int amount) {
		super();
		this.id = id;
		this.ref = ref;
		this.quantity = quantity;
		
		this.amount = ref.getPrice() * quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public int getPrice() {
		return price;
	}  
	
	public Reference getReference() {
        return this.reference;
    }
} */

