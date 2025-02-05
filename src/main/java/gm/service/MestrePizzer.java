package gm.service;

import gm.builder.PizzaBuilder;
import gm.model.Pizza;

public class MestrePizzer {
    private PizzaBuilder builder;

    public MestrePizzer(PizzaBuilder builder) {
        this.builder = builder;
    }

    public void setBuilder(PizzaBuilder builder) {
        this.builder = builder;
    }

    public Pizza makePizza() {
        return builder.build();
    }
}
