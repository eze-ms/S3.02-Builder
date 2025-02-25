package gm.builder;

import gm.model.Pizza;
import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder implements Builder {
    private String size = "Mediana";
    private String dough = "Clásica";
    private final List<String> toppings = new ArrayList<>();

    @Override
    public PizzaBuilder setSize(String size) {
        this.size = size;
        return this;
    }

    @Override
    public PizzaBuilder setDough(String dough) {
        this.dough = dough;
        return this;
    }

    @Override
    public PizzaBuilder addToppings(List<String> toppings) {
        this.toppings.addAll(toppings);
        return this;
    }

    @Override
    public Pizza construir() {
        return new Pizza(size, dough, toppings);
    }
}
