package main.java.ao.infra;

import main.java.ao.domain.Basket;
import main.java.ao.domain.BasketRepository;

import java.io.IOException;

import main.java.ao.domain.Basket;

public class BasketRepoMemory implements BasketRepository {
    private Basket basket;

    public BasketRepoMemory() {
        this.basket = null;
    }

    @Override
    public void save(Basket basket) {
        this.basket = basket;
    }

    @Override
    public Basket load() {
        return this.basket;
    }

}