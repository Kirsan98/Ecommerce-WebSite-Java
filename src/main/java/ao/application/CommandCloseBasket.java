package main.java.ao.application ;

import main.java.ao.domain.*;


public class CommandCloseBasket extends Command{
    //private String id  ; 
    private Basket cache;
    
    CommandCloseBasket(BasketRepository repository, Basket cache) {
        super(repository) ;
        this.cache = cache; 
        //this.id = id ; 
    }

    public void execute() {
        if(cache!=null){
            cache.closeBasket();
            super.repo.update(cache);
        }
    }

    public String toString(){
        return "Close basket command";
    }
}