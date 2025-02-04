package gm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pizza {
    private final String size;
    private final String dough;
    private final List<String> toppings;

    public Pizza(String size, String dough, List<String> toppings) {
        this.size = size;
        this.dough = dough;
        this.toppings = Collections.unmodifiableList(new ArrayList<>(toppings));
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
