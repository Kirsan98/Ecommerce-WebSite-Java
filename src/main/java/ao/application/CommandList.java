package main.java.ao.application ;

import java.util.*;

public class CommandList {
    private static List<Command> toExecute;
    
    public CommandList(){
        toExecute = new ArrayList<Command>() ;
    }

    public void addCommand(Command c){
        toExecute.add(c) ; 
        System.out.println("Command ajouté : "+toExecute.toString()+"\n");
    }

    public int getSize(){
        return toExecute.size();
    }

    public Command executeCommand() {
        Command c = toExecute.get(0) ; 
        toExecute.remove(0) ; 
        return c; 
    }

}