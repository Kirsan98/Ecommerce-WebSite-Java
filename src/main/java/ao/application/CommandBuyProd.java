package main.java.ao.application ;

import main.java.ao.domain.*;


public class CommandBuyProd extends Command{
    private String id;
    private Basket cache ; 
    private Reference product ; 
    private int nbP ; 
    
    
    CommandBuyProd(BasketRepository repo, String id, Reference product, int nbp) {
        super(repo) ; 
        this.id = id;
        this.cache = super.repo.findBasketById(id) ; 
        this.product = product ; 
        this.nbP = nbp ; 
    }
    public void execute() {
        this.cache.add(product, nbP);
        super.repo.updateById(id) ; 
    }

    public String toString(){
        return "Add product "+product.getName()+" to basket command : "+nbP;
    }
}