package main.java.ao.application ;

import main.java.ao.domain.BasketRepository;

public abstract class Command{
    protected BasketRepository repo ; 

    public Command(BasketRepository repo){
        this.repo = repo ;
    }
    
    public abstract void execute() ; 
    public abstract String toString() ; 
}