package main.java.ao.application;

import main.java.ao.domain.BasketRepository;
import main.java.ao.domain.Basket;
import main.java.ao.domain.Reference;

public class BasketService{
    Basket cache;
    BasketRepository repository;

    public int createNewBasket(){
        cache = factory.createBasket();
        repository.add(cache);
        return cache.getId();
    }


}