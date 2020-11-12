package main.java.ao.application ;

import main.java.ao.domain.Reference;
import main.java.ao.domain.*;


public class CommandBuyProd extends Command{
    private Basket cache;
    private Reference product ; 
    private int nbP ; 
    
    
    CommandBuyProd(Basket cache, Reference product, int nbp) {
        this.cache = cache;
        this.product = product ; 
        this.nbP = nbp ; 
    }
    public void execute() {
        this.cache.add(product, nbP);
    }

    public String toString(){
        return "Add product "+product.getName()+" to basket command\n";
    }
}