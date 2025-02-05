package gm.builder;

import gm.model.Pizza;

import java.util.List;

// Define métodos para configurar el tamaño, masa e ingredientes.
public interface PizzaBuilder {
    PizzaBuilder setSize(String size);
    PizzaBuilder setDough(String dough);
    PizzaBuilder setToppings(List<String> toppings);
    Pizza build();
}
