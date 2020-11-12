package main.java.ao.application ; 

public class Worker extends Thread {
    private CommandList toDo ; 

    public Worker(CommandList toDo) {
        this.toDo = toDo;
    }

    @Override
    public void run() {
        while(true) {
            //System.out.println("toDo list: "+toDo.toString()+"\n");
            // Command c = this.toDo.executeCommand() ; 
            if(toDo.getSize()>0){
                toDo.executeCommand();
                // System.out.println(c.toString());
            }
        }
    }
}