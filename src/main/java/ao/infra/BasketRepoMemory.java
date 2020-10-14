package main.java.ao.infra;

import main.java.ao.domain.Basket;
import main.java.ao.domain.BasketRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

import main.java.ao.domain.Basket;

public class BasketRepoMemory implements BasketRepository {
    //private Basket basket; 
    private Set<Basket> memory;

    public BasketRepoMemory() {
        //this.basket = null;
        this.memory = new HashSet();
    }

    public void add(Basket basket){
        this.memory.add(basket);
    }

    public void save(Basket basket) {
        this.memory.add(basket);
        /**
         * File f = new File (basket.id);
         * f.write(g...);
         */
         /**
          * memory.add(basket);
          */
    }

    /* public Basket load() {
        for (Set<Basket> m : memory) {
            return m;
        }
    } */

    public Basket findBasketById(int basketId){
        for(Basket b : memory){
            if(b.getId()==basketId) {
                return b;
            }
        }
        return null;
    }
}    