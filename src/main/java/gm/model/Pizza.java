package gm.model;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private final String tamaño;
    private final String masa;
    private final List<String> ingredientes;

    private Pizza(PizzaBuilder builder) {
        this.tamaño = builder.tamaño;
        this.masa = builder.masa;
        this.ingredientes = List.copyOf(builder.ingredientes);
    }

    public static PizzaBuilder builder() {
        return new PizzaBuilder();
    }

    public static class PizzaBuilder {
        private String tamaño = "Mediana";
        private String masa = "Clásica";
        private final List<String> ingredientes = new ArrayList<>();

        public PizzaBuilder setTamaño(String tamaño) {
            this.tamaño = tamaño;
            return this;
        }

        public PizzaBuilder setMasa(String masa) {
            this.masa = masa;
            return this;
        }

        public PizzaBuilder agregarIngredientes(List<String> ingredientes) {
            this.ingredientes.addAll(ingredientes);
            return this;
        }

        public Pizza construir() {
            return new Pizza(this);
        }
    }


    @Override
    public String toString() {
        return """
            Tamaño: %s
            Masa: %s
            Ingredientes: %s
            """.formatted(tamaño, masa, String.join(", ", ingredientes));
    }

}
