package main.java.ao;

import main.java.ao.domain.BasketRepository;
import main.java.ao.infra.BasketRepoMemory;
import main.java.ao.application.BasketService;
import main.java.ao.domain.Basket;
import main.java.ao.domain.Reference;

public class Main {
  public static void main(String[] args) {

    Reference p1 = new Reference("A1","Table","Petite table a manger",9);
    Reference p2 = new Reference("A2","Table","Petite table a manger",9);
    
    //Test Basket (création aggregat)
    Basket b = new Basket(1);
    
    b.add(p1, 9);  
    System.out.println(b.toString());
    b.add(p2,2);
    System.out.println(b.toString()+"\n");
    b.remove(p2);
    System.out.println(b.toString()+"\n");

    // Test Repo 
    BasketRepository repo;
    repo = new BasketRepoMemory();
    repo.save(b);
    System.out.println(repo.findBasketById(b.getId()));

    // Test Application (Service)
    BasketService bs = new BasketService();
    int id = bs.createNewBasket();
    //
  }
}