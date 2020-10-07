/* // ValueObject
package main.java.ao.domain;

import java.util.*;
import java.lang.*;
import java.security.InvalidParameterException;

public class Produit {
    
    private final Reference ref;
    private final Name nom;
    private final Description description;
    private final Price prix;

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
    private final String nom;

    public Name(String nom) throws InvalidParameterException {
        if( nom==null || nom.length()>20){
            throw new InvalidParameterException();
        } 
        else{
            this.nom = nom; 
        }
    }

    public boolean equals(Object obj) {
        if( !(obj instanceof Name)) return false;
        Name otherName = (Name) obj;
        boolean sameName = this.nom == otherName.nom;
        return sameName;
    }

    public int hashCode() {
        return Objects.hash(nom);
    }

    public String toString(){
        return "Name: "+nom+super.toString();
    }
}

//
class Description{
    private final String description;

    public Description(String description) throws InvalidParameterException{
        if(description==null || description.length()>200){
            throw new InvalidParameterException();
        }
        else{
            this.description = description;    
        }
    }

    public int hashCode() {
        return Objects.hash(description);
    }

    public boolean equals(Object obj) {
        if( !(obj instanceof Description)) return false;
        Description otherDescription = (Description) obj;
        boolean samedescription = this.description == otherDescription.description;
        return samedescription;
    }

    public String toString(){
        return "Description: "+description+super.toString();
    }
}

//
class Reference{
    private final String ref;

    public Reference(String ref) throws InvalidParameterException{
        if (isAlphanumeric(ref) == true && ref.length()<=20 && ref!=null){
            this.ref = ref;
        }
        else{
            throw new InvalidParameterException();
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

    public int hashCode() {
        return Objects.hash (ref);
    }

    public boolean equals(Object obj) {
        if( !(obj instanceof Reference)) return false;
        Reference otherReference = (Reference) obj;
        boolean sameReference = this.ref == otherReference.ref;
        return sameReference;
    }

    public String toString(){
        return "Reference: "+ref+super.toString();
    }
}

//
class Price{
    private final int prix;

    public Price(int prix) throws InvalidParameterException{
        if(prix>0){
            this.prix=prix;
        }
        else{
            throw new InvalidParameterException();
        }
    }

    public boolean equals(Object obj) {
        if( !(obj instanceof Price)) return false;
        Price otherPrice = (Price) obj;
        boolean samePrice = this.prix == otherPrice.prix;
        return samePrice;
    }

    public int hashCode() {
        return Objects.hash(prix);
    }

    public String toString(){
        return "Price: "+prix+super.toString();
    }
}
 */