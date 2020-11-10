package main.java.ao.application ;

import main.java.ao.domain.*;


public class CommandCloseBasket extends Command{
    private String id  ; 
    private BasketRepository repository ; 

    
    CommandCloseBasket(String id , BasketRepository repository) {
        this.id = id ; 
        this.repository = repository ; 
    }

    public void execute() {
        Basket basket = repository.findBasketById(id) ; 
        basket.closeBasket();
    }
}