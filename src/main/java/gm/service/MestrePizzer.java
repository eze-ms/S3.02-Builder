package gm.service;

import gm.builder.PizzaBuilder;
import gm.model.Pizza;

import java.util.List;

public class MestrePizzer {
    private final PizzaBuilder builder;

    public MestrePizzer(PizzaBuilder builder) {
        this.builder = builder;
    }

    public Pizza prepararPizzaHawaiana(String size, String dough) {
        builder.setSize(size).setDough(dough).addToppings(List.of("piña", "queso", "jamón"));
        return builder.construir();
    }

    public Pizza prepararPizzaVegetariana(String size, String dough) {
        builder.setSize(size)
                .setDough(dough)
                .addToppings(List.of("champiñones", "pimientos", "cebolla", "aceitunas", "queso", "tomate"));
        return builder.construir();
    }

    public Pizza configurarPizzaPersonalizada(String size, String dough, List<String> toppings) {
        builder.setSize(size)
                .setDough(dough)
                .addToppings(toppings);
        return builder.construir();
    }
}
