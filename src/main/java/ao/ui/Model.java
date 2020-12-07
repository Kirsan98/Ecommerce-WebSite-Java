package main.java.ao.ui;

import main.java.ao.domain.Reference;
import main.java.ao.application.*;
import java.util.* ; 


public class Model {

    public enum Step {
        INITIAL_STEP ,
        CREATE_STEP ,
        ADD_STEP ,
        REMOVE_STEP ,
        CLOSE_STEP ;

    }

    /**
     * KIRSAN PART
     */

    // private BasketService basketService;
    // private String username; // id of the user
    // private Model stepCode;

    // public Model(BasketService basketService, String username){
    //     this.basketService = basketService;
    //     this.username = username;
    // }

    // public void Step(int stepCode) {
    //     this.stepCode = stepCode;
    // }

    // public String getUsername(){
    //     return this.username;
    // }
    
    // public Step getStepCode() {
    //     return this.stepCode;
    // }

    //Step myVar = Step.INITIAL_STEP; 

    private static List<Reference> products = new ArrayList<Reference>() ; 
    private static boolean basketClose ;  
    public static Set<Reference>  inBasket = new HashSet<Reference>() ;  


    public Model() {
        basketClose = false ; 
        initRef() ; 
    }

    private void initRef(){
        String[] name = {"Arthur", "Parseval", "Lancelot", "Accolon", "Keu" } ; 
        for (int i = 0 ; i<5 ; i++) {
            // products.add(new Reference("ID "+i, 
                            // name[i], "un preux chevalier, "+name[i]+
                            // " de la table ronde vous garantie sa splandeur ", (2*i+3))); 
            Reference toAdd = new Reference("ID"+i, name[i], "table ronde", 9) ; 
            products.add(toAdd) ; 
        }
    }

    public List<Reference> getReference() {
        return this.products ; 
    }

    public boolean getBasketEnd() {
        return basketClose ; 
    }

    // Doit seulement être utiliser par le controlleur
    public void updatebasketClose(boolean b) { 
        basketClose = b ; 
    }

    public void updatebasketRef(Reference newRef){
        this.inBasket.add(newRef) ; 
    }

    public String inMyBasket(){
        String inside = " "; 
        for (Reference ref : this.inBasket) {
            inside += ref.toString() ; 
        }
        return inside; 
    }

    public void removeRef(Reference ref){
        this.inBasket.remove(ref) ; 
    }
}