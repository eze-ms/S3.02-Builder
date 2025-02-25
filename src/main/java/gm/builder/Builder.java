package gm.builder;

import gm.model.Pizza;
import java.util.List;

public interface Builder {
    Builder setSize(String size);
    Builder setDough(String dough);
    Builder addToppings(List<String> toppings);
    Pizza construir();
}
