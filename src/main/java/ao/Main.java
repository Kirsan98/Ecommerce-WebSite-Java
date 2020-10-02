package main.java.ao;

public class Main {
  public static void main(String[] args) {
    Reference r;
    Name n;
    Description d;
    Price p;
    r = new Reference("A1");
    n = new Name("Table");
    d = new Description("Petite table à manger\n");
    p = new Price(9);

    Produit p1 = new Produit(r,n,d,p);
    
    System.out.println("Hello World\n"+p1.toString());
  }
}