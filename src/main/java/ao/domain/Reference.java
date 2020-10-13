    // ValueObject
package main.java.ao.domain;

import java.security.InvalidParameterException;
import java.util.*;

public class Reference {
    
    private final String id;
    private final String name;
    private final String description;
    private final int price;

    public String getId() {
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
    }

    public boolean equals(Object obj) {
        if( !(obj instanceof Reference)) return false;
        Reference otherReference = (Reference) obj;
        boolean sameid = this.id == otherReference.getId();
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
