package main.java.ao;

public class Main {
  public static void main(String[] args) {
    
    Reference r = new Reference("A1");
    Name n = new Name("Table");
    Description d = new Description("Petite table à manger\n");
    Price p = new Price(9);

    Produit p1 = new Produit(r,n,d,p);
    
    System.out.println("Hello World\n"+p1.toString());
  }
}