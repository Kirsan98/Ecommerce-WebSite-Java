package main.java.ao;

import main.java.ao.domain.Basket;
import main.java.ao.domain.Reference;

public class Main {
  public static void main(String[] args) {

    Reference p1 = new Reference("A1","Table","Petite table a manger",9);
    
    Basket b = new Basket();
    
    b.add(p1, 9);

    System.out.println(b.toString());
  }
}