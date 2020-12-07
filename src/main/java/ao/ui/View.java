package main.java.ao.ui;

import main.java.ao.application.*;
import java.lang.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner; 

import main.java.ao.domain.Reference;


public class View extends Thread {

    private Model model;
    private Controller controller ; 
    private String basketID ; 
    private StateViewer stateView ; 
    private String name ; 
    private Scanner scan; 
    
    public View(){
        this.model = new Model() ; 
        this.controller = new Controller() ;
        this.stateView = StateViewer.MENU ; 
        this.scan = new Scanner(System.in) ;  
        this.name = null ; 
    }

    public void run() {
        boolean end = false ;  
        while(!end) {
            switch (this.stateView) {
                case MENU : 
                    if (this.name==null) {
                        System.out.println("Bienvenue, vous êtes dans le Menu ^^\n "
                                            + "comment vous vous apellez ?" ) ;
                        String name = scan.nextLine() ; 
                        this.name = name ; 
                    }
                    menu() ;  
                    break ; 
                case BASKET : 
                    System.out.println("Un panier vous sera attribué pour que vous puissez faire vos course") ; 
                    refresh();
                    this.stateView = StateViewer.MENU ; 
                    break ; 
                case SHOP : 
                    System.out.println("") ; 
                    shop() ; 
                    if (this.model.getBasketEnd()) {
                        this.stateView = StateViewer.FINISH ; 
                    }
                    this.stateView = StateViewer.MENU ; 
                    break ;
                case DELETE : 
                    System.out.println("Vous vous apprétez à supprimer un produit de votre panier") ;
                    delete() ; 
                    this.stateView = StateViewer.MENU ; 
                    break ; 
                case FINISH : 
                    System.out.println("Merci beaucoup, se fut un réel plaisir de vous accueillir "+ this.name) ;
                    end = finish() ; 
                    if (!end) this.stateView = StateViewer.MENU ; 
                    break ; 
            }
        }
    }

    public void refresh() {
        boolean done = false ; 
        while(!done){
            System.out.println(this.name+",  tappez (1) pour créer un panier ou (2) pour ouvrir panier existant");
            String answer = scan.nextLine(); 
            int intAnswer = Integer.parseInt(answer) ; 
            if (intAnswer==1) {
                this.basketID = controller.newBasket() ; 
                done = true ; 
            }
            else if (intAnswer == 2){
                System.out.println("Enter basket id:");
                String answerBasketId = scan.nextLine();
                if(controller.inRegister(basketID)){
                    System.out.println("Your basket has been found");
                    this.basketID = answerBasketId ; 
                    done = true; 
                }else{
                    System.out.println("Your basket has not been found");
                }
            }
        }
    }

    private void shop() {
        boolean done = false ;
        List<Reference> inShop = model.getReference() ; 
        for (int i = 0 ; i<inShop.size() ; i++)
            System.out.println(this.name+" tappez "+i+" pour acheter "+inShop.get(i).getName() + ". Cette article est à "+inShop.get(i).getPrice());
        while (!done){
            if(model.getBasketEnd()){
                System.out.println("Votre panier est fermé!\n");
                done = true;
            }
            System.out.println("veuillez choisir un article ou tapez (-1) pour revenir dans le menu\n") ;
            String answer = scan.nextLine(); 
            int intAnswer = Integer.parseInt(answer) ; 
            if (intAnswer>=0 && intAnswer<inShop.size()){
                System.out.println("Combien en voulez-vous\n") ;
                String answer2 = scan.nextLine() ; 
                int intAnswer2 = Integer.parseInt(answer2) ;
                this.controller.buyArticle(inShop.get(intAnswer), intAnswer2, model);
                done = true ;  
            }else if (intAnswer==-1){
                this.stateView = StateViewer.MENU;
                menu();
                //this.controller.closeBasket(model) ;
                done = true ;  
            }
        }
    }

    private boolean finish() {
        System.out.println(this.name + " saisissez (1) pour quitter  ou (2) pour retourner menu\n") ; 
        String answer = scan.nextLine() ; 
        int intAnswer = Integer.parseInt(answer) ;
        if (intAnswer==1){
            System.out.println("merci de votre visite et à bientôt\n");
            return true ; 
        }
        return false ; 
    }

    private void menu() {
        System.out.println("\n\nBienvenue à toi, "+this.name+"\n Voici le Menu, et voici ton id de panier: " + basketID + " veuillez faire votre choix :\n" );
        boolean done = false ; 
        while (!done){
            System.out.println("Tapez ("+1+") pour choisir ou changer votre panier "); 
            System.out.println("Tapez ("+2+") pour aller dans le magasin") ; 
            System.out.println("Tapez ("+3+") pour voir votre panier"); 
            System.out.println("Tapez ("+4+") pour supprimer un produit dans votre panier"); 
            System.out.println("Tapez ("+5+") pour cloturer votre achat et fermer votre panier!"); 
            String answer = scan.nextLine(); 
            int intAnswer = Integer.parseInt(answer) ; 
            switch (intAnswer) {
                case 1 : 
                    this.stateView = StateViewer.BASKET ;
                    done = true ; 
                    break ;  
                case 2 : 
                    this.stateView = StateViewer.SHOP ; 
                    done = true ; 
                    break ; 
                case 3 : 
                    if(basketID==null){
                        System.out.println("Creer un panier avant d'utiliser cette commande\n");
                    }
                    else {
                        System.out.println("Alors voici ce que tu as dans ton panier actuel :\n"+
                                        model.inMyBasket());
                    }
                    done = true ; 
                    break ; 
                case 5 : 
                    controller.closeBasket(model);
                    done = true ; 
                    break ; 
                case 4 : 
                    this.stateView = StateViewer.DELETE ; 
                    done = true ; 
                    break ; 
                case -1 : 
                    this.stateView = StateViewer.FINISH ; 
                    done = true ; 
                    break ; 
                default : 
                System.out.println("vous avez tapez un mauvais numéro, attention !"); 
            }
        }
    }

    // TODO 
    private void delete(){
        System.out.print("voici la liste de votre panier\n"+model.inMyBasket()+"\n\n") ;
        int i = 0 ;  
        HashMap<Reference,Integer> commandLine = model.getInbasket() ; 
        for (Map.Entry m : commandLine.entrySet()) {
            System.out.println("Tapez ("+i+") pour supprimer "+m.getKey());
            i++ ; 
        }
        boolean done = false ; 
        while (!done){
            System.out.println("que souhaitez vous supp ?") ; 
            String answer = scan.nextLine() ; 
            int intAnswer = Integer.parseInt(answer) ; 
            if (intAnswer>=0 && intAnswer<i){
                System.out.println("D'accord nous allons supprimer ce produit de votre panier");
                System.out.println("combien en souhaiter vous supp ?") ; 
                String answer2 = scan.nextLine() ; 
                int intAnswer2 = Integer.parseInt(answer2) ; 
                i = intAnswer ; 
                Reference ref ;
                for (Map.Entry<Reference,Integer> m : commandLine.entrySet()) {
                    if (i==0) {
                        controller.deleteRef(m.getKey(), intAnswer2, model); 
                        break ; 
                    }
                    i-- ; 
                }
                done = true ; 
            }else{
                System.out.println("Mauvaise saisie, veuillez recommencer") ; 
            }
        }

    }
}