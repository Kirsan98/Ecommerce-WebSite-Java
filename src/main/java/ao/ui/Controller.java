package main.java.ao.ui ;

import main.java.ao.domain.Reference;
import main.java.ao.application.BasketService;
import main.java.ao.domain.BasketRepository;
import main.java.ao.infra.* ; 

public class Controller{

    private BasketService command ; 
    private String id ; 
    private BasketRepository repository; 

    public Controller() {
        repository = new BasketRepoMemory(); 
        command = new BasketService(repository) ; 
        
    }

    public String newBasket() {
        id = command.createNewBasket() ; 
        return  id ; 
    }

    public boolean inRegister(String basketID){
        return command.getInRepo(basketID) ;
    }

    public void buyArticle(Reference ref, int nbP, Model model) {
        command.buyProduct(this.id, ref, nbP);
        model.updatebasketRef(ref,nbP);
    }

    public void closeBasket(Model model) {
        command.closeBasket(this.id);
        model.updatebasketClose(true);
    }

    public void deleteRef(Reference ref, int nbP, Model model){
        command.removeProduct(id, ref, nbP);
        if (!command.productInBasket(id, ref)){
            model.removeRef(ref) ; 
        }
    }

}