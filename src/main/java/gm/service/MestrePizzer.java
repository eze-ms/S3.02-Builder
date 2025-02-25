package gm.service;

import gm.builder.PizzaBuilder;
import gm.model.Pizza;

import java.util.List;

public class MestrePizzer {
    private final PizzaBuilder builder;

    public MestrePizzer(PizzaBuilder builder) {
        this.builder = builder;
    }

    public Pizza prepararPizzaHawaiana(String tamaño, String masa) {
        configurarBase(tamaño, masa);
        builder.agregarIngredientes(List.of("piña", "queso", "jamón"));
        System.out.println("Preparando Pizza Hawaiana...");
        return builder.construir();
    }

    public Pizza prepararPizzaVegetariana(String tamaño, String masa) {
        configurarBase(tamaño, masa);
        builder.agregarIngredientes(List.of("champiñones", "pimientos", "cebolla", "aceitunas", "queso", "tomate"));
        System.out.println("Preparando Pizza Vegetariana...");
        return builder.construir();
    }

    public Pizza configurarPizzaPersonalizada(String tamaño, String masa, List<String> ingredientes) {
        configurarBase(tamaño, masa);
        builder.agregarIngredientes(ingredientes);
        return builder.construir();
    }

    private void configurarBase(String tamaño, String masa) {
        builder.setTamaño(tamaño);
        builder.setMasa(masa);
    }
}
