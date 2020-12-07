package main.java.ao.domain;

import java.io.IOException;

import main.java.ao.domain.Basket;

public interface BasketRepository {
    public void save(Basket basket); 
    public Basket findBasketById(String basketId);
    public void update(Basket cache);
    public void updateById(String basketId) ;  
}