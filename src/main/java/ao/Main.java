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
    
    System.out.println("Test Basket\n");
    //Test Basket (création aggregat)
    Basket b = new Basket("1");
    b.add(p1, 9);  
    System.out.println(b.toString());
    b.add(p2,2);
    System.out.println(b.toString()+"\n");
    b.remove(p2);
    System.out.println(b.toString()+"\n");

    System.out.println("Test Repo\n");
    // Test Repo 
    BasketRepository repo;
    repo = new BasketRepoMemory();
    repo.save(b);
    System.out.println(repo.findBasketById(b.getId()));

    System.out.println("Test Service\n");
    // Test Application (Service)
    BasketService bs = new BasketService(repo);
    String id = bs.createNewBasket();
    System.out.println(id);

    System.out.println(bs.productInBasket(id, p1));
    
    bs.buyProduct(id, p1, 4);
    System.out.println(bs.productInBasket(id, p1));

    System.out.println(bs.totalInBasket(id));

    bs.removeProduct(id, p1, 1);
    System.out.println(bs.totalInBasket(id));
    bs.removeProduct(id, p1, 4); // Ne doit pas fonctionner 
    System.out.println(bs.totalInBasket(id));
    bs.removeProduct(id, p1, 3); // Doit fonctionner 
    System.out.println(bs.totalInBasket(id));
    
    bs.closeBasket(id);
    bs.buyProduct(id, p2, 1); // Ne doit pas fonctionner car basket est fermé


    //
  }
}