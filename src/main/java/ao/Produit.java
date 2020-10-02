// ValueObject
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

    public void Produit() {
    }

    public void Produit(Reference ref, Name nom, Description description, Price prix) {
        this.ref = ref;
        this.nom = nom;
        this.description = description;
        this.prix = prix; 
    }

    public String toString(){
        System.out.println("Référence: "+ this.ref + ", Name: "+this.name+", Description: "+this.description+ ", Price: "+this.price);
    }
    // TODO Surcharger la méthode equals et hashcode pour faire en sorte que l'égalité soit une égalité de valeur.
}

// ValueObject
class Name{
    private final String nom;

    public Name(String nom){
        if(nom.length()>20){
            System.err.println("Nom supérieur à 20 caractère\n");
        } 
        this.nom = nom; 
    }

}

class Description{
    private final String description;

    public Description(String description){
        if(description.length()>200){
            System.err.println("Description supérieur à 200 caractère\n");
        }
        this.description = description;
    }
}

class Reference{
    private String ref;

    public Reference(String ref){
        if (isAlphanumeric(ref) == true && ref.length()<=20){
            this.ref = ref;
        }
        System.err.println("Reference doit être alphanumérique de taille 20 au maximum\n");
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
        System.err.println("Prix doit être un entier positif\n");
    }
}
