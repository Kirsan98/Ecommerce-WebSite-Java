package main.java.ao.domain;

import java.security.InvalidParameterException;

public class CommandLine {
	private Reference ref; 
	private int quantity ; 
	private int amount;
	
	public CommandLine(Reference ref,int quantity) throws InvalidParameterException {
		this.ref = ref;
		if(quantity <=0){
			throw new InvalidParameterException();
		}
		else {
			this.quantity = quantity;
		}
		this.amount = ref.getPrice() * quantity;
	}

	public int getQuantity(){
		return quantity;
	}
	
	public int getAmount() {
		return amount;
	}  
	
	public Reference getReference() {
        return ref;
	}
	
	public String toString(){
        return "Référence: "+ ref.toString() + ", Amount: "+amount+ " Quantity: " + quantity +"\n";
    }
} 