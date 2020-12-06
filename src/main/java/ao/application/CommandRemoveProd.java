package main.java.ao.application ;

import main.java.ao.domain.Reference;
import main.java.ao.domain.*;


public class CommandRemoveProd extends Command{
    //private String id ;
    private Basket cache ; 
    private Reference product ; 
    private int nbProductToRemove;
    
    CommandRemoveProd(BasketRepository repo, Basket cache, Reference product, int nbProductToRemove) {
        super(repo) ; 
        //this.id = id ; 
        this.cache = cache;
        this.product = product ; 
        this.nbProductToRemove = nbProductToRemove;
    }

    public void execute() {
        // this.cache = super.repo.findBasketById(id);
        int i = nbProductToRemove ;
        while(i>0){
            cache.remove(product);
            i--;
        }
        super.repo.update(cache);
    }

    public String toString(){
        return "Remove product \""+product.getName()+"\" "+this.nbProductToRemove+" times"+"  to basket command";
    }
}