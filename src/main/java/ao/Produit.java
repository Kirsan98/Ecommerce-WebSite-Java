// ValueObject
package main.java.ao;

import java.util.*;

public class Produit {
   
    private Reference ref;
    private Name nom;
    private Description description;
    private Price prix;

    public Reference getRef() {
        return ref;
    }

    public Name getNom() {
        return nom;
    }

    public Description getDescription() {
        return description;
    }

    public Price getPrix() {
        return prix;
    }

    public Produit(Reference ref, Name nom, Description description, Price prix) {
        this.ref = ref;
        this.nom = nom;
        this.description = description;
        this.prix = prix; 
    }

    public String toString(){
        return "Référence: "+ ref + ", Name: "+nom+", Description: "+description+ ", Price: "+prix+super.toString();
    }

    public int hashCode() {
        return Objects.hash(ref,nom,description,prix);
    }

   public boolean equals(Object obj) {
       if( !(obj instanceof Produit)) return false;
       Produit otherProduit = (Produit) obj;
       boolean sameref = this.ref == otherProduit.getRef();
       boolean samenom = this.nom == otherProduit.getNom();
       boolean samedescription = this.description == otherProduit.getDescription();
       boolean sameprix = this.prix == otherProduit.getPrix();
       return sameref && samenom && samedescription && sameprix;
   }
}

// ValueObject
class Name{
    private String nom;

    public Name(String nom){
        if(nom.length()>20){
            System.err.println("Nom supérieur à 20 caractère\n");
        } 
        else{
            this.nom = nom; 
        }
    }

}

class Description{
    private String description;

    public Description(String description){
        if(description.length()>200){
            System.err.println("Description supérieur à 200 caractère\n");
        }
        else{
            this.description = description;    
        }
    }
}

class Reference{
    private String ref;

    public Reference(String ref){
        if (isAlphanumeric(ref) == true && ref.length()<=20){
            this.ref = ref;
        }
        else{
            System.err.println("Reference doit être alphanumérique de taille 20 au maximum\n");
        }
    }

    public boolean isAlphanumeric(String str)
    {
       char[] charArray = str.toCharArray();
       for(char c:charArray)
       {
           if (!Character.isLetterOrDigit(c))
               return false;
       }
       return true;
    }
}

class Price{
    private int prix;

    public Price(int prix){
        if(prix>0){
            this.prix=prix;
        }
        else{
            System.err.println("Prix doit être un entier positif\n");
        }
    }
}
