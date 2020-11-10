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
        this.repository = repository;
        this.commandWait = new CommandList();
        Worker w = new Worker() ; 
        w.start();
    }

    //command
    public String createNewBasket(){ 
        String uniqueID = UUID.randomUUID().toString();
        this.cache = new Basket(uniqueID);
        repository.add(this.cache);
        return cache.getId();
    }

    public void buyProduct(String id, Reference product, int nbP){
        commandWait.addCommand(new CommandBuyProd(id,repository,product,nbP));
    }

    public void removeProduct(String id, Reference product,int nbProductToRemove) {
        commandWait.addCommand(new CommandRemoveProd(id,repository,product,nbProductToRemove));
    }
    
    public void closeBasket(String id ){ 
        commandWait.addCommand(new CommandCloseBasket(id,repository));
    }

    //Query
    public boolean productInBasket(String id , Reference product) {
        this.cache = repository.findBasketById(id) ; 
        return cache.isReferenceInBasket(product) ; 
    }

    public int totalInBasket(String id ) {
        this.cache = repository.findBasketById(id) ; 
        return cache.getSum() ; 
    }


}