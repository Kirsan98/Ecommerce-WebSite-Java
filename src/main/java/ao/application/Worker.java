package main.java.ao.application ; 

public class Worker extends Thread {
    private CommandList toDo ; 

    public Worker(CommandList toDo) {
        this.toDo = toDo;
    }

    @Override
    public void run() {
        while(true) {
            if(toDo.getSize()>0){
                toDo.executeCommand();
            }
        }
    }
}