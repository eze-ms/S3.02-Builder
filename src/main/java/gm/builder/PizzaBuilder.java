package gm.builder;

import gm.model.Pizza;
import java.util.ArrayList;
import java.util.List;

public class PizzaBuilder implements Builder {
    private String tamaño = "Mediana";
    private String masa = "Clásica";
    private final List<String> ingredientes = new ArrayList<>();

    @Override
    public PizzaBuilder setTamaño(String tamaño) {
        this.tamaño = tamaño;
        return this;
    }

    @Override
    public PizzaBuilder setMasa(String masa) {
        this.masa = masa;
        return this;
    }

    @Override
    public PizzaBuilder agregarIngredientes(List<String> ingredientes) {
        this.ingredientes.addAll(ingredientes);
        return this;
    }

    @Override
    public Pizza construir() {
        return new Pizza(tamaño, masa, ingredientes);
    }
}
