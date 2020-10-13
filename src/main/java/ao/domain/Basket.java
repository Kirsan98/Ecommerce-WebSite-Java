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
	
	//constructeur
	public Basket() {
		this.commandLine = new HashMap<>() ; 
		this.basketClose = false ; 
	}
	
	//get
	public int getSum() {
		return sum;
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
 		if (this.isReferenceInBasket(product) || nbP<=0) {
            throw new IllegalArgumentException();
        } 
		if (!basketClose) {
			this.sum += nbP * product.getPrice();
			if (commandLine.containsKey(product)) {
				int newPrice = commandLine.get(product).getAmount()+product.getPrice()*nbP;
				int newQuantity = commandLine.get(product).getQuantity()+nbP;
				CommandLine newCommandLine = new CommandLine(product, nbP);
				commandLine.replace(product, newCommandLine) ;
			}
			else {
				commandLine.put(product, new CommandLine(product, nbP)); 
			}
		}
		else {
			throw new IllegalAccessError("This basket is close it cannot be modified !\n");
		}
	}

	public String toString(){
        return "Sum: " + sum + "\n"+commandLine.toString() + "\n";
    }
	
	public void remove(Reference product) throws InvalidParameterException {
		if (!basketClose && commandLine.containsKey(product)) { 
			int nbP = commandLine.get(product).getQuantity() - 1 ; 
			this.sum -= product.getPrice();
			if (nbP==0){
				commandLine.remove(product) ; 
			}
			else {
				CommandLine newCommandLine = new CommandLine(product, nbP);
				commandLine.replace(product, newCommandLine);
			}
		}
		return;
	}

	public void closeBasket() {
		basketClose = true ; 
	}

	public BasketDTO getDTO() {
        return new BasketDTO(this.basketClose, new HashMap<>(this.commandLine));
    }
}
