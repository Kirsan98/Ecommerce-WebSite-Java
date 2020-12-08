package main.java.ao.ui;

import main.java.ao.domain.Reference;
import java.util.List ; 
import java.util.HashMap; 
import java.util.ArrayList; 
import java.util.Map; 


public class Model {

    private List<Reference> products = new ArrayList<Reference>() ; 
    private boolean basketClose ;  
    public HashMap<Reference,Integer> inBasket = new HashMap<Reference, Integer>() ;  

    public Model() {
        basketClose = false ; 
        initRef() ; 
    }

    private void initRef(){
        String[] name = {"Arthur", "Parseval", "Lancelot", "Accolon", "Keu" } ; 
        for (int i = 0 ; i<name.length ; i++) {
            Reference toAdd = new Reference("ID"+i, name[i], "table ronde", 9) ; 
            products.add(toAdd) ; 
        }
    }

    public List<Reference> getReference() {
        return this.products ; 
    }

    public boolean getBasketEnd() {
        return basketClose ; 
    }

    // Doit seulement être utiliser par le controlleur
    public void updatebasketClose(boolean b) { 
        basketClose = b ; 
    }

    public void updatebasketRef(Reference newRef, int nbProduct){
        this.inBasket.put(newRef,nbProduct); 
    }

    public String inMyBasket(){
        String inside = ""; 
        if(inBasket.size()==0){
            return "Ton panier est vide\n";
        }
        int i = 0;
        for (Map.Entry<Reference,Integer> entry : inBasket.entrySet()) {
            inside += "Reference " + entry.getKey() ;
            inside += "Nombre de produits ajoutés "+ entry.getValue();
            i++; 
        }
        return inside; 
    }

    public void removeRef(Reference ref){
        this.inBasket.remove(ref) ; 
    }

    public HashMap<Reference,Integer> getInbasket() {
        return this.inBasket ; 
    }
}