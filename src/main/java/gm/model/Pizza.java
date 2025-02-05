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

    public List<String> getToppings() {
        return toppings;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "\nsize='" + size + '\'' +
                ",\ndough='" + dough + '\'' +
                ",\ntoppings=" + toppings +
                '}';
    }
}
