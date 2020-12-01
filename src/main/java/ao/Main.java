package main.java.ao;

import main.java.ao.domain.BasketRepository;
import main.java.ao.infra.BasketRepoMemory;
import main.java.ao.application.BasketService;
import main.java.ao.domain.Basket;
import main.java.ao.domain.Reference;
import java.lang.Thread;

public class Main {
  public static void main(String[] args) throws InterruptedException{

    Reference p1 = new Reference("A1","Table","Petite table a manger",9);
    Reference p2 = new Reference("A2","Table","Petite table a manger",9);
    
    System.out.println("#####################\n"+"#Test Basket\n"+"#####################\n");
    //Test Basket (création aggregat)
    Basket b = new Basket("1");
    b.add(p1, 9);  
    System.out.println(b.toString());
    b.add(p2,2);
    System.out.println(b.toString()+"\n");
    b.remove(p2);
    System.out.println(b.toString()+"\n");

    System.out.println("#####################\n"+"#Test Repo\n"+"#####################\n");
    // Test Repo 
    BasketRepository repo;
    repo = new BasketRepoMemory();
    repo.save(b);
    System.out.println(repo.findBasketById(b.getId()));

    System.out.println("#####################\n"+"#Test Service\n"+"#####################\n");
    // Test Application (Service)
    BasketService bs = new BasketService(repo);
    String id = bs.createNewBasket();
    System.out.println(id);
    bs.productInBasket(id, p1);
    
    bs.buyProduct(id, p1, 4);
    // Thread.sleep(1000);
    bs.productInBasket(id, p1);
    bs.totalInBasket(id);

    bs.removeProduct(id, p1, 1);
    // Thread.sleep(1000);
    System.out.println(bs.totalInBasket(id));
    //bs.removeProduct(id, p1, 4); // Ne doit pas fonctionner 
    bs.removeProduct(id, p1, 3); // Doit fonctionner 
    // Thread.sleep(1000);
    System.out.println(bs.totalInBasket(id));
    
    bs.closeBasket(id);
    // Thread.sleep(1000);
  }
}