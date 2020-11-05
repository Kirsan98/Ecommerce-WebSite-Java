package main.java.ao.application ;

import main.java.ao.domain.*;


public class CommandRemoveProd extends Command{
    private int id ; 
    private BasketRepository repository ; 
    private Reference product ; 
    
    
    CommandRemoveProd(int id, BasketRepository repository, Reference product) {
        this.id = id ; 
        this.repository = repository ; 
        this.product = product ; 
    }

    public void execute() {
        Basket basket = repository.findBasketById(id) ; 
        basket.remove(product);
    }
}