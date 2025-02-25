package gm.controller;

import gm.builder.PizzaBuilder;
import gm.model.Pizza;
import gm.service.MestrePizzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private boolean salir = false;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void mostrarMenu() {
        while (!salir) {
            imprimirOpcionesMenu();
            int opcion = obtenerOpcion();
            procesarOpcion(opcion);
        }
    }

    private void imprimirOpcionesMenu() {
        System.out.println("\nMenú - Crear tu Pizza:");
        System.out.println("1. Pizza Hawaiana");
        System.out.println("2. Pizza Vegetariana");
        System.out.println("3. Crear pizza personalizada");
        System.out.println("4. Salir");
        System.out.print("Elige una opción: ");
    }

    private int obtenerOpcion() {
        while (true) {
            try {
                int opcion = Integer.parseInt(scanner.nextLine());
                if (opcion >= 1 && opcion <= 4) {
                    return opcion;
                } else {
                    System.out.println("Error: Ingresa un número entre 1 y 4.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número válido.");
            }
        }
    }

    private void procesarOpcion(int opcion) {
        if (opcion == 4) {
            confirmarSalida();
        } else {
            construirPizza(opcion);
        }
    }

    private void construirPizza(int tipo) {
        PizzaBuilder builder = new PizzaBuilder();
        MestrePizzer mestre = new MestrePizzer(builder);

        String tamaño = pedirOpcion("Elige el tamaño (Pequeña, Mediana, Grande): ",
                Arrays.asList("pequeña", "mediana", "grande"));
        String masa = pedirOpcion("Elige el tipo de masa (Fina, Gruesa, Rellena): ",
                Arrays.asList("fina", "gruesa", "rellena"));

        Pizza pizza = null;
        switch (tipo) {
            case 1 -> pizza = mestre.prepararPizzaHawaiana(tamaño, masa);
            case 2 -> pizza = mestre.prepararPizzaVegetariana(tamaño, masa);
            case 3 -> {
                List<String> ingredientes = pedirIngredientes();
                pizza = mestre.configurarPizzaPersonalizada(tamaño, masa, ingredientes);
            }
        }

        if (pizza != null) {
            System.out.println("\nTu pizza ha sido creada con éxito:");
            System.out.println(pizza);
        }
    }

    private String pedirOpcion(String mensaje, List<String> opciones) {
        while (true) {
            System.out.print(mensaje);
            String opcion = scanner.nextLine().trim().toLowerCase();
            if (opciones.contains(opcion)) {
                return opcion;
            }
            System.out.println("Error: Debes elegir entre " + String.join(", ", opciones) + ".");
        }
    }

    private List<String> pedirIngredientes() {
        while (true) {
            System.out.print("Ingresa los ingredientes separados por comas (mínimo 1): ");
            List<String> ingredientes = Arrays.stream(scanner.nextLine().split(","))
                    .map(String::trim)
                    .filter(s -> !s.isEmpty())
                    .toList();

            if (!ingredientes.isEmpty()) {
                return new ArrayList<>(ingredientes);
            }
            System.out.println("Debes agregar al menos un ingrediente.");
        }
    }

    private void confirmarSalida() {
        System.out.print("¿Seguro que quieres salir? (s/n): ");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        if (respuesta.equals("s")) {
            salir = true;
            System.out.println("Saliendo del sistema...");
        }
    }
}