package main.java.ao.application ;

import main.java.ao.domain.Reference;
import main.java.ao.domain.*;


public class CommandRemoveProd extends Command{
    private Basket cache;
    private Reference product ; 
    private int nbProductToRemove;
    
    CommandRemoveProd(Basket cache, Reference product, int nbProductToRemove) {
        this.cache = cache;
        this.product = product ; 
        this.nbProductToRemove = nbProductToRemove;
    }

    public void execute() {
        while(nbProductToRemove>0){
            cache.remove(product);
            this.nbProductToRemove--;
        }
    }

    public String toString(){
        return "Remove product ("+product.getName()+")  to basket command\n";
    }
}