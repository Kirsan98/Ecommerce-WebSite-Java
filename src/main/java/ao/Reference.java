	// ValueObject
package main.java.ao;

import java.security.InvalidParameterException;

public class Reference {
    
    private final String ref;
    private final String name;
    private final String description;
    private final int price;

    public String getRef() {
        return ref;
    }

    public String getname() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public Reference(String ref, String name, String description, int price) throws InvalidParameterException {
    	if (!(isAlphanumeric(ref) == true && ref.length()<=20 && ref!=null) || 
    			!( name!=null && name.length()<20) || (description==null || description.length()>200)){
    		throw new InvalidParameterException();
        }
    	this.ref = ref ; 
        this.name = name;
        this.description = description;
        this.price = price; 
    }

    public String toString(){
        return "Référence: "+ ref + ", Name: "+name+", Description: "+description+ ", Price: "+price+"\n";
    }

    public int hashCode() {
        //return Objects.hash(ref,name,description,price);
    	int hash = 1 ; 
    	hash = hash*31 + (ref==null ? 0 : ref.hashCode()) ;
    	hash = hash*31 + (name==null ? 0 : name.hashCode()) ; 
    	hash = hash*31 + (description==null ? 0 : description.hashCode()) ; 
    	hash = hash*31 + price ; 
    	return hash ; 
    }

   public boolean equals(Object obj) {
       if( !(obj instanceof Reference)) return false;
       Reference otherReference = (Reference) obj;
       boolean sameref = this.ref == otherReference.getRef();
       boolean samename = this.name == otherReference.getname();
       boolean samedescription = this.description == otherReference.getDescription();
       boolean sameprice = this.price == otherReference.getPrice();
       return sameref && samename && samedescription && sameprice;
   }
   
   private boolean isAlphanumeric(String str)
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
