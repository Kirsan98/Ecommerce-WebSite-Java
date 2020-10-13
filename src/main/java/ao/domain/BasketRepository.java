package main.java.ao.domain;

import java.io.IOException;

import main.java.ao.domain.Basket;

public interface BasketRepository {
    public void save(Basket basket); // exception métier ?
    //public void update(Basket basket);
    public Basket load();
    //public Basket findBasketById(int basketId);
}