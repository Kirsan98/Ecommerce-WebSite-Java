package main.java.ao.application ;

import main.java.ao.domain.*;


public class CommandCloseBasket extends Command{
    private String id  ; 
    
    CommandCloseBasket(BasketRepository repository, String id) {
        super(repository) ; 
        this.id = id ; 
    }

    public void execute() {
        Basket basket = super.repo.findBasketById(id) ; 
        basket.closeBasket();
        super.repo.updateById(id) ; 
    }

    public String toString(){
        return "Close basket command";
    }
}