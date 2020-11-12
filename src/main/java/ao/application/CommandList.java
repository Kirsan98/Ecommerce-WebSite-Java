package main.java.ao.application ;

import java.util.*;

public class CommandList {
    private List<Command> toExecute;
    
    public CommandList(){
        this.toExecute = new ArrayList<Command>() ;
    }

    public void addCommand(Command c){
        this.toExecute.add(c) ; 
        System.out.println("Command ajouté : "+toExecute.toString()+"\n");
    }

    public Command executeCommand() {
        Command c = toExecute.remove(0) ; 
        System.out.println("Command executé: "+toExecute.toString()+"\n");
        return c; 
    }

    public String toString(){
        String result = "Command : ";
        for (Command command : toExecute) {
            result = result + command;
        }
        return result;
    }

}