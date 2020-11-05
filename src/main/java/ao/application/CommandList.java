package main.java.ao.application ;

import java.util.*;

public class CommandList {
    private static List<Command> toExecute = new ArrayList<Command>() ;
    
    public CommandList(){
        super() ; 
    }


    public void addCommand(Command c){
        toExecute.add(c) ; 
    }

    public Command executeCommand() {
        Command c = toExecute.get(0) ; 
        toExecute.remove(0) ; 
        return c; 
    }

}