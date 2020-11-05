package main.java.ao.domain;

import java.io.IOException;

import main.java.ao.domain.Basket;

public interface BasketRepository {
    public void save(Basket basket); 
    public void add(Basket basket); 
    public Basket findBasketById(int basketId);
}