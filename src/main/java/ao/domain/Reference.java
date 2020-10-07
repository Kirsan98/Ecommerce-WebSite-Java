    // ValueObject
package main.java.ao.domain;

import java.security.InvalidParameterException;
import java.util.*;

public class Reference {
    
    private final String id;
    private final String name;
    private final String description;
    private final int price;

    public String getid() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public Reference(String id, String name, String description, int price) throws InvalidParameterException {
    	if (!(isAlphanumeric(id) == true && id.length()<=20 && id!=null) || 
    			!( name!=null && name.length()<20) || (description==null || description.length()>200)){
    		throw new InvalidParameterException();
        }
    	this.id = id ; 
        this.name = name;
        this.description = description;
        this.price = price; 
    }

    public String toString(){
        return "Id: "+ id + ", Name: "+name+", Description: "+description+ ", Price: "+price+"\n";
    }

    public int hashCode() {
        return Objects.hash(id,name,description,price);
    	/* int hash = 1 ; 
    	hash = hash*31 + (id==null ? 0 : id.hashCode()) ;
    	hash = hash*31 + (name==null ? 0 : name.hashCode()) ; 
    	hash = hash*31 + (description==null ? 0 : description.hashCode()) ; 
    	hash = hash*31 + price ; 
    	return hash ; */ 
    }

    public boolean equals(Object obj) {
        if( !(obj instanceof Reference)) return false;
        Reference otherReference = (Reference) obj;
        boolean sameid = this.id == otherReference.getid();
        boolean samename = this.name == otherReference.getName();
        boolean samedescription = this.description == otherReference.getDescription();
        boolean sameprice = this.price == otherReference.getPrice();
        return sameid && samename && samedescription && sameprice;
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
