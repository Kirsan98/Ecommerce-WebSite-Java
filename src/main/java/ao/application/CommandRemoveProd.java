package main.java.ao.application ;

import main.java.ao.domain.*;


public class CommandRemoveProd extends Command{
    private String id ; 
    private BasketRepository repository ; 
    private Reference product ; 
    private int nbProductToRemove;
    
    CommandRemoveProd(String id, BasketRepository repository, Reference product, int nbProductToRemove) {
        this.id = id ; 
        this.repository = repository ; 
        this.product = product ; 
        this.nbProductToRemove = nbProductToRemove;
    }

    public void execute() {
        Basket basket = repository.findBasketById(id) ; 
        while(nbProductToRemove>0){
            basket.remove(product);
            this.nbProductToRemove--;
        }
    }
}