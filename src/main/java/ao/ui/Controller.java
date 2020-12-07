package main.java.ao.ui ;

import main.java.ao.domain.Reference;
import main.java.ao.application.BasketService;
import main.java.ao.domain.BasketRepository;
import main.java.ao.infra.* ; 

public class Controller{

    private BasketService command ; 
    private String id ; 
    private BasketRepository repository; 
    private Model model ; 

    public Controller() {
        repository = new BasketRepoMemory(); 
        command = new BasketService(repository) ; 
        model = new Model() ; 
        
    }

    public String newBasket() {
        id = command.createNewBasket() ; 
        return  id ; 
    }

    public boolean inRegister(String basketID){
        return command.inRepo(basketID) ;
    }

    public void buyArticle(Reference ref, int nbP) {
        command.buyProduct(this.id, ref, nbP);
    }

    public void closeBasket() {
        command.closeBasket(this.id);
        model.updatebasketClose(true);
    }

}