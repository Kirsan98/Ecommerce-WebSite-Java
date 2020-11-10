package main.java.ao.application ;

import main.java.ao.domain.*;


public class CommandBuyProd extends Command{
    private String id  ; 
    private BasketRepository repository ; 
    private Reference product ; 
    private int nbP ; 
    
    
    CommandBuyProd(String id , BasketRepository repository, Reference product, int nbp) {
        this.id = id ; 
        this.repository = repository ; 
        this.product = product ; 
        this.nbP = nbp ; 
    }
    public void execute() {
        Basket basket = repository.findBasketById(id) ; 
        basket.add(product, nbP);
    }
}