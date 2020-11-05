package main.java.ao.application ; 

public class Worker extends Thread {
    private CommandList toDo ; 

    public Worker() {}

    @Override
    public void run() {
        while(true) {
            Command c = toDo.executeCommand() ; 
            c.execute();
        }
    }
}