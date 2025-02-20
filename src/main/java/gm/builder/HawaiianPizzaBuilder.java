package gm.builder;

import gm.model.Pizza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HawaiianPizzaBuilder implements PizzaBuilder {
    private String size = "medium";
    private String dough = "classic";
    private final List<String> toppings;

    public HawaiianPizzaBuilder() {
        this.toppings = new ArrayList<>();
        initializeDefaultToppings();
    }

    private void initializeDefaultToppings() {
        toppings.add("pineapple");
        toppings.add("cheese");
        toppings.add("ham");
    }

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
    public PizzaBuilder setToppings(List<String> toppings) {
        this.toppings.clear();
        this.toppings.addAll(toppings);
        return this;
    }

    @Override
    public PizzaBuilder addToppings(List<String> toppings) {
        this.toppings.addAll(toppings);
        return this;
    }


    @Override
    public Pizza build() {
        return new Pizza(size, dough, Collections.unmodifiableList(toppings));
    }
}
