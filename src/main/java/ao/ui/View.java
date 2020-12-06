package main.java.ao.ui;

import main.java.ao.application.*;

public class View{

    private Model model;
    
    public View(){
        Model model = new Model(bs, username);
    }

    public void refresh() {
        if (model.stepCode == Step.INITIAL_STEP) {
            System.out.println("Bienvenue "+model.getUsername()+" tappez (1) pour créer un panier ou (2) pour ouvrir panier existant");
        }
    }
}