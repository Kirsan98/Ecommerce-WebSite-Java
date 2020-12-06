package main.java.ao.ui;

import main.java.ao.application.*;

public class Model {

    public enum Step {
        INITIAL_STEP ,
        CREATE_STEP ,
        ADD_STEP ,
        REMOVE_STEP ,
        CLOSE_STEP ;

    }

    private BasketService basketService;
    private String username; // id of the user
    private final int stepCode;

    public Model(BasketService basketService, String username){
        this.basketService = basketService;
        this.username = username;
    }

    public void Step(int stepCode) {
        this.stepCode = stepCode;
    }

    public String getUsername(){
        return this.username;
    }
    
    // public Step getStepCode() {
    //     return this.stepCode;
    // }

    //Step myVar = Step.INITIAL_STEP; 
}