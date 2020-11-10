package main.java.ao.infra;

import main.java.ao.domain.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

import main.java.ao.domain.Basket;

public class BasketRepoMemory implements BasketRepository {
    private static Set<Basket> memory;

    public BasketRepoMemory() {
        super() ; 
        this.memory = new HashSet();
    }

    public void add(Basket basket){
        this.memory.add(basket);
    }

    public void save(Basket basket) {
        this.memory.add(basket);
    }

    public Basket findBasketById(String basketId){
        for(Basket b : memory){
            if(b.getId()==basketId) {
                return b;
            }
        }
        return null;
    }
}    