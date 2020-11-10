package main.java.ao.application ; 

public class Worker extends Thread {
    private CommandList toDo ; 

    public Worker() {
        this.toDo = new CommandList();
    }

    @Override
    public void run() {
        while(true) {
            if(toDo.getSize()!=0){
                System.out.println("toDo list: "+toDo.toString()+"\n");
                Command c = toDo.executeCommand() ; 
                c.execute();
            }
        }
    }
}