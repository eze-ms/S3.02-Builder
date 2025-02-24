package gm.service;

import gm.model.Pizza;

public class MestrePizzer {
    private Pizza.PizzaBuilder builder;

    public MestrePizzer() {
        this.builder = Pizza.builder();
    }

    public void setBuilder(Pizza.PizzaBuilder builder) {
        this.builder = builder;
    }

    public Pizza hacerPizza() {
        return builder.construir();
    }
}
