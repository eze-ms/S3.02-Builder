package gm.controller;

import gm.excepcion.EntradaInvalidaException;
import gm.model.Pizza;

import java.util.List;
import java.util.Scanner;

public class GestorPizzas {
    private final Scanner scanner;

    public GestorPizzas(Scanner scanner) {
        this.scanner = scanner;
    }

    public void prepararPizzaHawaiana(Pizza.PizzaBuilder builder) {
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                builder.setTamaño(pedirTamaño());
                builder.setMasa(pedirMasa());
                builder.agregarIngredientes(List.of("piña", "queso", "jamón"));
                entradaValida = true;
                System.out.println("Preparando Pizza Hawaiana...");
            } catch (EntradaInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void prepararPizzaVegetariana(Pizza.PizzaBuilder builder) {
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                builder.setTamaño(pedirTamaño());
                builder.setMasa(pedirMasa());
                builder.agregarIngredientes(List.of("champiñones", "pimientos", "cebolla", "aceitunas", "queso", "tomate"));
                entradaValida = true;
                System.out.println("Preparando Pizza Vegetariana...");
            } catch (EntradaInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void configurarPizzaPersonalizada(Pizza.PizzaBuilder builder) {
        boolean entradaValida = false;
        while (!entradaValida) {
            try {
                builder.setTamaño(pedirTamaño());
                builder.setMasa(pedirMasa());
                entradaValida = true;
            } catch (EntradaInvalidaException e) {
                System.out.println(e.getMessage());
            }
        }

        agregarIngredientesExtra(builder);
    }

    private String pedirTamaño() {
        System.out.print("Elige el tamaño (Pequeña, Mediana, Grande): ");
        String tamaño = scanner.nextLine().trim().toLowerCase();

        if (!tamaño.equals("pequeña") && !tamaño.equals("mediana") && !tamaño.equals("grande")) {
            throw new EntradaInvalidaException("Error: Debes elegir entre Pequeña, Mediana o Grande.");
        }
        return tamaño;
    }

    private String pedirMasa() {
        System.out.print("Elige el tipo de masa (Fina, Gruesa, Rellena): ");
        String masa = scanner.nextLine().trim().toLowerCase();

        if (!masa.equals("fina") && !masa.equals("gruesa") && !masa.equals("rellena")) {
            throw new EntradaInvalidaException("Error: Debes elegir entre Fina, Gruesa o Rellena.");
        }
        return masa;
    }

    private void agregarIngredientesExtra(Pizza.PizzaBuilder builder) {
        List<String> ingredientes;
        do {
            System.out.print("Ingresa los ingredientes separados por comas (mínimo 1): ");
            ingredientes = List.of(scanner.nextLine().split(","))
                    .stream()
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .toList();

            if (ingredientes.isEmpty()) {
                System.out.println("Debes agregar al menos un ingrediente.");
            }
        } while (ingredientes.isEmpty());

        builder.agregarIngredientes(ingredientes);
    }
}
