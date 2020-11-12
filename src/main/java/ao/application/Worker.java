package main.java.ao.application ; 

public class Worker extends Thread {
    private CommandList toDo ; 

    public Worker(CommandList toDo) {
        this.toDo = toDo;
    }

    @Override
    public synchronized void run() {
        while(true) {
            //System.out.println("toDo list: "+toDo.toString()+"\n");
            Command c = this.toDo.executeCommand() ; 
            if(c!=null){
                c.execute();
            }
        }
    }
}