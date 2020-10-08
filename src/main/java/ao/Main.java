package main.java.ao;

import main.java.ao.domain.Basket;
import main.java.ao.domain.Reference;

public class Main {
  public static void main(String[] args) {

    Reference p1 = new Reference("A1","Table","Petite table a manger",9);
    Reference p2 = new Reference("A2","Table","Petite table a manger",9);
    
    Basket b = new Basket();
    
    //Test ajout
    b.add(p1, 9);
    //b.add(p1, 9);
    //b.add(p1, -9);
    
    //Test sum 
    //System.out.println((b.getSum()==81));

    System.out.println(b.toString());

    //Test basket closed
    //b.closeBasket(); 

    b.add(p2,2);
    System.out.println(b.toString()+"\n");
    b.remove(p2);
    System.out.println(b.toString()+"\n");
  }
}