package gm.model;

import java.util.List;

public class Pizza {
    private final String size;
    private final String dough;
    private final List<String> toppings;

    public Pizza(String size, String dough, List<String> toppings) {
        this.size = size;
        this.dough = dough;
        this.toppings = List.copyOf(toppings);
    }

    @Override
    public String toString() {
        return "\n Pizza creada:" +
                "\n Tamaño: " + size +
                "\n Masa: " + dough +
                "\n Ingredientes: " + toppings;
    }
}
