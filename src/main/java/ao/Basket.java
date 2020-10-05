package main.java.ao;

import java.security.InvalidParameterException;
import java.util.*;

public class Basket {
	//entity
	private int sum ; // somme des lignes de commandes 
	private HashMap<Reference, CommandLine> commandLine  ; // ligne de commande 
										               // (K = réf, V = quantité)
	private List<Reference> products  ; //liste de tout les produits disponible du magasin
	private boolean basketClose ; 
	
	//constructeurr
	public Basket() {
		this.sum = 0 ; 
		this.commandLine = new HashMap<Reference, CommandLine>() ; 
		this.products = new ArrayList<Reference>() ; 
		this.basketClose = false ; 
		market() ; 
	}
	
	private void market() {
		products.add(new Reference("A1", "table", "table design", 3)) ; 
	}
	
	//get
	public int getSum() {
		return sum;
	}

	public HashMap<Reference, CommandLine> getCommandLine() {
		return commandLine;
	}

	public List<Reference> getProduits() {
		return products;
	}

	//méthode
	
	public void buy(Reference product, int nbP) throws InvalidParameterException {
		if (products.contains(product)|| nbP < 0) 
			throw new InvalidParameterException()  ; 
		if (!basketClose) {
			if (commandLine.containsKey(product)) {
				int newPrice = commandLine.get(product).getPrice()+product.getPrice()*nbP ;
				int newQuantity = commandLine.get(product).getQuantity()+nbP;
				commandLine.replace(product,new CommandLine(newQuantity, newPrice)) ;
			}
			else commandLine.put(product, new CommandLine(nbP, product.getPrice()*nbP)) ; 
			sum += nbP*product.getPrice() ; 
	
		}
	}
	
	public void remove(Reference product) throws InvalidParameterException {
		if (products.contains(product)) 
			throw new InvalidParameterException()  ;
		
		if (!basketClose && commandLine.containsKey(product)) { 
			int nbP = commandLine.get(product).getQuantity() - 1 ; 
			if (nbP==0)
				commandLine.remove(product) ; 
			else {
				int newPrice = commandLine.get(product).getPrice()-product.getPrice() ;
				commandLine.replace(product,new CommandLine(nbP, newPrice)) ;
			}
		}
	}
	public void closeBasket() {
		basketClose = true ; 
	}
	
	public String inBasket() {
		String in = "" ; 
		for (Map.Entry<Reference, CommandLine> m : commandLine.entrySet()) {
			in = in + m.getKey().getname()+ " : quantity = " + m.getValue().getQuantity()+
					" | price = "+m.getValue().getPrice() + "\n"; 
		}
		return in ; 
	}
	
	
}
