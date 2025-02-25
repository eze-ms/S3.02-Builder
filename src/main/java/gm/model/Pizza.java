package gm.model;

import java.util.List;

public class Pizza {
    private final String tamaño;
    private final String masa;
    private final List<String> ingredientes;

    public Pizza(String tamaño, String masa, List<String> ingredientes) {
        this.tamaño = tamaño;
        this.masa = masa;
        this.ingredientes = List.copyOf(ingredientes);
    }

    @Override
    public String toString() {
        return "\n Pizza creada:" +
                "\n Tamaño: " + tamaño +
                "\n Masa: " + masa +
                "\n Ingredientes: " + ingredientes;
    }
}
