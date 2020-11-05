package main.java.ao.application;

import main.java.ao.domain.BasketRepository;
import main.java.ao.domain.Basket;
import main.java.ao.domain.Reference;

public class BasketService{
    private Basket cache;
    private BasketRepository repository;
    private CommandList commandWait ; 

    public BasketService() {
        super() ; 
    }

    //command
    public int createNewBasket(){ 
        int newId = 0 ;
        while(repository.findBasketById(newId)!=null) newId+=1 ;  
        cache = new Basket(newId);
        repository.add(cache);
        Worker w = new Worker() ; 
        w.run();
        return cache.getId();
    }

    public void buyProduct(int id, Reference product, int nbP){
        cache = repository.findBasketById(id) ; 
        commandWait.addCommand(new CommandBuyProd(id,repository,product,nbP));
    }

    public void removeProduct(int id, Reference product) {
        cache = repository.findBasketById(id) ; 
        commandWait.addCommand(new CommandRemoveProd(id,repository,product));
    }
    
    public void closeBasket(int id){ 
        cache = repository.findBasketById(id) ; 
        commandWait.addCommand(new CommandCloseBasket(id,repository));
    }

    //Query
    public boolean productInBasket(int id, Reference product) {
        cache = repository.findBasketById(id) ; 
        return cache.isReferenceInBasket(product) ; 
    }

    public int totalInBasket(int id) {
        cache = repository.findBasketById(id) ; 
        return cache.getSum() ; 
    }


}