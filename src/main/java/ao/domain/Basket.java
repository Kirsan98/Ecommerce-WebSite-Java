package main.java.ao.domain;

import java.security.InvalidParameterException;
import java.util.*;
import java.lang.*;

public class Basket {
	//entity
	private int sum ; // somme des lignes de commandes 
	private HashMap<Reference, CommandLine> commandLine  ; 	// ligne de commande 
										               		// (K = ref, V = quantite 
	private boolean basketClose ; 
	
	//constructeurr
	public Basket() {
		this.commandLine = new HashMap<Reference, CommandLine>() ; 
		this.basketClose = false ; 
		for (Map.Entry me : commandLine.entrySet()) {
			this.sum = this.sum + commandLine.get(me.getKey()).getAmount();
        }
	}
	
	//get
	public int getSum() {
		return sum;
	}

	public HashMap<Reference, CommandLine> getCommandLine() {
		return commandLine;
	}

	//methode
	public boolean isReferenceInBasket(Reference reference) {
		if (commandLine.containsKey(reference)){
			return true;
		}
		else{
			return false;
		}
    }
	
	public void add(Reference product, int nbP) throws InvalidParameterException {
 		if (this.isReferenceInBasket(product)) {
            throw new IllegalArgumentException("Reference already in basket !\n");
        } 
		if (nbP < 0) 
			throw new InvalidParameterException("Quantity of product must be greater than 0\n")  ; 
		if (!basketClose) {
			if (commandLine.containsKey(product)) {
				int newPrice = commandLine.get(product).getAmount()+product.getPrice()*nbP;
				int newQuantity = commandLine.get(product).getQuantity()+nbP;

				CommandLine newCommandLine = new CommandLine(product, nbP);
				commandLine.replace(product, newCommandLine) ;
			}
			else commandLine.put(product, new CommandLine(product, nbP)); 
			sum += nbP*product.getPrice() ; 
		}
		else {
			throw new IllegalAccessError("This basket is close it cannot be modified !\n");
		}
	}

	public String toString(){
        return "Sum: " + sum + "\n"+commandLine.toString() + "\n";
    }
	
	public void remove(Reference product) throws InvalidParameterException {
		int newPrice;
		if (!basketClose && commandLine.containsKey(product)) { 
			int nbP = commandLine.get(product).getQuantity() - 1 ; 
			if (nbP==0){
				newPrice = getSum()-commandLine.get(product).getReference().getPrice();
				sum = newPrice;
				commandLine.remove(product) ; 
			}
			else {
				CommandLine newCommandLine = new CommandLine(product, nbP);
				commandLine.replace(product, newCommandLine) ;
				newPrice = getSum()-commandLine.get(product).getReference().getPrice();
				sum = newPrice;	
			}
		}
	}

	public void closeBasket() {
		basketClose = true ; 
	}
	
	/* public String inBasket() {
		String in = "" ; 
		for (Map.Entry<Reference, CommandLine> m : commandLine.entrySet()) {
			in = in + m.getKey().getname()+ " : quantity = " + m.getValue().getQuantity()+
					" | price = "+m.getValue().getPrice() + "\n"; 
		}
		return in ; 
	} */
	
	
}
