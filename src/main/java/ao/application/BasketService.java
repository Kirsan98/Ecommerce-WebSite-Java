package main.java.ao.application;

import main.java.ao.domain.BasketRepository;
import main.java.ao.domain.Basket;
import main.java.ao.domain.Reference;
import java.util.*;

public class BasketService{
    private Basket cache;
    private int nbProductToRemove;
    private BasketRepository repository;
    private CommandList commandWait ; 

    public BasketService(BasketRepository repository) {
        this.cache = null;
        this.repository = repository;
        this.commandWait = new CommandList();
        Worker w = new Worker(this.commandWait) ; 
        w.start();
    }

    //command
    public String createNewBasket(){ 
        String basketId = UUID.randomUUID().toString();
        this.cache = new Basket(basketId);
        repository.add(this.cache);
        return basketId;
    }

    public void buyProduct(String id, Reference product, int nbP){
        commandWait.addCommand(new CommandBuyProd(repository, id, product, nbP));
    }

    public void removeProduct(String id, Reference product,int nbProductToRemove) {
        commandWait.addCommand(new CommandRemoveProd(repository, id, product,nbProductToRemove));
    }
    
    public void closeBasket(String id ){ 
        commandWait.addCommand(new CommandCloseBasket(repository, id));
    }

    //Query
    public boolean productInBasket(String id , Reference product) {
        this.cache = repository.findBasketById(id) ; 
        System.out.println("Product : \""+product.getName()+ "\" is in Basket :"+cache.isReferenceInBasket(product)+"\n");
        return cache.isReferenceInBasket(product) ; 
    }

    public int totalInBasket(String id ) {
        this.cache = repository.findBasketById(id) ; 
        System.out.println("Total in basket : "+cache.getSum());
        return cache.getSum() ; 
    }

    public String toString(){
        return "Cache " + this.cache + " Repository " + this.repository + " CommandList "+ this.commandWait + "Nb product to remove " + this.nbProductToRemove + " \n";
    }


}