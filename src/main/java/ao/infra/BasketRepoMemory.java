package main.java.ao.infra;

import main.java.ao.domain.Basket;
import main.java.ao.domain.BasketRepository;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import main.java.ao.domain.Basket;

public class BasketRepoMemory implements BasketRepository {
    private Basket basket; 
    //private Set<Basket> memory;

    public BasketRepoMemory() {
        this.basket = null;
        //memory = new HashSet<Basket>();
    }

    @Override
    public void save(Basket basket) {
        this.basket = basket;

        /**
         * File f = new File (basket.id);
         * f.write(g...);
         */

         /**
          * memory.add(basket);
          */
    }

    @Override
    public Basket load() {
        return this.basket;
    }

    //public Basket findBasketById(int basketId){

        /* for(Basket b : memory){
            if(b.getId()==basketId)  
                return b;
        } */
        
        //File data = new File(basketId);

        //File data = new File("test.json");
        // lire les données sauvegardés (fichier, bdd, etc)
        //data = File.read();

        // Construire l'aggregate
        //Basket b = new Basket(data.read());

        // et enfin restaurer son état 
        // TODO

        //return b;
    //}

}