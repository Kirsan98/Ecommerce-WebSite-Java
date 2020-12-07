package main.java.ao.ui;

import main.java.ao.application.*;
import java.lang.*;
import java.util.List;
import java.util.Scanner; 

import main.java.ao.domain.Reference;

/**
 * connais le modèle et le controlleur 
 */

public class View extends Thread {

    private Model model;
    private Controller controller ; 
    private String basketID ; 
    private StateViewer stateView ; 
    private String name ; 
    private Scanner scan; 
    
    public View(){
        // this.model = new Model(bs, username); // model.stepCode = INITIAL_STEP
        this.model = new Model() ; 
        this.controller = new Controller() ;
        this.stateView = StateViewer.MENU ; 
        this.scan = new Scanner(System.in) ;  
    }

    public void run() {
        boolean end = false ;  
        while(!end) {
            switch (this.stateView) {
                case MENU : 
                    System.out.println("Bienvenu, vous êtes dans Menu ^^\n "
                                        + "comment vous vous apellez ?" ) ;
                    // CONTROLLER TODO
                    String name = scan.nextLine() ; 
                    this.name = name ; 

                    this.stateView = StateViewer.BASKET ; 
                    break ; 
                case BASKET : 
                    System.out.println("Un panier vous sera attribué pour que vous puissez faire vos course") ; 
                    refresh();
                    this.stateView = StateViewer.SHOP ; 
                    break ; 
                case SHOP : 
                    System.out.println("Un panier vous sera attribué pour que vous puissez faire vos course") ; 
                    // TODO
                    shop() ; 
                    if (this.model.getBasketEnd()) {
                        this.stateView = StateViewer.FINISH ; 
                    }
                    break ; 
                case FINISH : 
                    System.out.println("Merci de votre achat, se fut un réel plaisir de vous accueillir "+ this.name) ;
                    // TODO
                    end = finish() ; 
                    
                    break ; 
            }
        }
    }

    public void refresh() {
        boolean done = false ; 
        while(!done){
            // if (model.getStepCode() == Model.Step.INITIAL_STEP) {
                System.out.println("Bienvenue "+this.name+",  tappez (1) pour créer un panier ou (2) pour ouvrir panier existant");
                String answer = scan.nextLine(); 
                int intAnswer = Integer.parseInt(answer) ; 
                if (intAnswer==1) {
                    // CONTROLLER TODO
                    this.basketID = controller.newBasket() ; 
                    done = true ; 
                }
                else if (intAnswer == 2){
                    System.out.println("Enter basket id:");
                    String answerBasketId = scan.nextLine();
                    // CONTROLLER TODO
                    if(controller.inRegister(basketID)){
                        System.out.println("Your basket has been found");
                        this.basketID = answerBasketId ; 
                        done = true; 
                    }else{
                        System.out.println("Your basket has not been found");
                    }
                }
            // }else{
                // done = true ; 
            // }
        }
    }

    private void shop() {
        boolean done = false ;
        // MODEL TODO
        List<Reference> inShop = model.getReference() ; 
        for (int i = 0 ; i<inShop.size() ; i++)
            System.out.println(this.name+" tappez "+i+" pour acheter "+inShop.get(i).getName() + ". Cette article est à "+inShop.get(i).getPrice());
        while (!done){
            System.out.println("veuillez choisir un article ou tapez -1 pour stopper vos achats") ;
            String answer = scan.nextLine(); 
            int intAnswer = Integer.parseInt(answer) ; 
            if (intAnswer>=0 && intAnswer<inShop.size()){
                // CONTROLLER TODO
                System.out.println("Combien en voulez-vous") ;
                String answer2 = scan.nextLine() ; 
                int intAnswer2 = Integer.parseInt(answer) ;

                this.controller.buyArticle(inShop.get(intAnswer), intAnswer2) ;
                done = true ;  
            }else if (intAnswer==-1){
                // CONTROLLER TODO
                this.controller.closeBasket() ; 
            }
        }
    }

    public boolean finish() {
        System.out.println(this.name + " saisissez (1) pour quitter  ou (2) pour retourner menu") ; 
        String answer = scan.nextLine() ; 
        int intAnswer = Integer.parseInt(answer) ;
        if (intAnswer==1){
            System.out.println("merci de votre visite et à bientôt");
            return true ; 
        }
        return false ; 
    }
}