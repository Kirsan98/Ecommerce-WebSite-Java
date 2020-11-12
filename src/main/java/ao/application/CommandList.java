package main.java.ao.application ;

import java.util.*;

public class CommandList {
    private static List<Command> toExecute;
    
    public CommandList(){
        this.toExecute = new ArrayList<Command>() ;
    }

    public synchronized void addCommand(Command c){
        this.toExecute.add(c) ; 
        System.out.println("Command ajouté : "+toExecute.toString()+"\n");
    }

    public synchronized void executeCommand() {
        toExecute.get(0).execute(); 
        toExecute.get(0).toString() ; 
        System.out.println("Command executé: "+toExecute.toString()+"\n");
        toExecute.remove(0) ; 
    }

    public synchronized String toString(){
        String result = "Command : ";
        for (Command command : toExecute) {
            result = result + command;
        }
        return result;
    }

    public synchronized int getSize(){
        return toExecute.size() ; 
    }
}