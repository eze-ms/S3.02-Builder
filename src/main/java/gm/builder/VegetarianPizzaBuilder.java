package gm.builder;

import gm.model.Pizza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VegetarianPizzaBuilder implements PizzaBuilder {
    private String size = "medium";
    private String dough = "classic";
    private List<String> toppings;

    public VegetarianPizzaBuilder() {
        this.toppings = new ArrayList<>();
        initializeDefaultToppings();
    }

    private void initializeDefaultToppings() {
        this.toppings = new ArrayList<>();
        toppings.add("mushrooms");
        toppings.add("peppers");
        toppings.add("onions");
        toppings.add("olives");
        toppings.add("cheese");
        toppings.add("tomato");
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
        this.toppings = new ArrayList<>(toppings);
        return this;
    }

    @Override
    public Pizza build() {
        return new Pizza(size, dough, Collections.unmodifiableList(toppings));
    }
}
