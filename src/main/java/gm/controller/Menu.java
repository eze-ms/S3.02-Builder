package gm.controller;

import gm.builder.PizzaBuilder;
import gm.model.Pizza;
import gm.service.MestrePizzer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Menu {
    private final Scanner scanner;
    private boolean salir = false;

    private static final int OPCION_HAWAIANA = 1;
    private static final int OPCION_VEGETARIANA = 2;
    private static final int OPCION_PERSONALIZADA = 3;
    private static final int OPCION_SALIR = 4;

    private static final List<String> TAMANOS_VALIDOS = Arrays.asList("pequeña", "mediana", "grande");
    private static final List<String> MASAS_VALIDAS = Arrays.asList("fina", "gruesa", "rellena");

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void mostrarMenu() {
        while (!salir) {
            imprimirOpcionesMenu();
            int option = obtenerOpcion();
            procesarOpcion(option);
        }
    }

    private void imprimirOpcionesMenu() {
        System.out.println("\nMenú - Crear tu Pizza:");
        System.out.println(OPCION_HAWAIANA + ". Pizza Hawaiana");
        System.out.println(OPCION_VEGETARIANA + ". Pizza Vegetariana");
        System.out.println(OPCION_PERSONALIZADA + ". Crear pizza personalizada");
        System.out.println(OPCION_SALIR + ". Salir");
        System.out.print("Elige una opción: ");
    }

    private int obtenerOpcion() {
        int option = -1;

        while (true) {
            System.out.print("Elige una opción: ");
            String input = scanner.nextLine();

            try {
                option = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: Ingresa un número válido.");
                continue;
            }

            if (option >= OPCION_HAWAIANA && option <= OPCION_SALIR) {
                return option;
            }
            System.out.println("Error: Ingresa un número entre " + OPCION_HAWAIANA + " y " + OPCION_SALIR + ".");
        }
    }

    private void procesarOpcion(int opcion) {
        if (opcion == OPCION_SALIR) {
            confirmarSalida();
        } else {
            construirPizza(opcion);
        }
    }

    private void construirPizza(int tipo) {
        PizzaBuilder builder = new PizzaBuilder();
        MestrePizzer mestre = new MestrePizzer(builder);

        String size = pedirOpcion("Elige el tamaño (Pequeña, Mediana, Grande): ", TAMANOS_VALIDOS);
        String dough = pedirOpcion("Elige el tipo de masa (Fina, Gruesa, Rellena): ", MASAS_VALIDAS);

        Pizza pizza = null;
        switch (tipo) {
            case OPCION_HAWAIANA -> pizza = mestre.prepararPizzaHawaiana(size, dough);
            case OPCION_VEGETARIANA -> pizza = mestre.prepararPizzaVegetariana(size, dough);
            case OPCION_PERSONALIZADA -> {
                List<String> toppings = pedirIngredientes();
                pizza = mestre.configurarPizzaPersonalizada(size, dough, toppings);
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
            String option = scanner.nextLine().trim();
            if (opciones.stream().anyMatch(op -> op.equalsIgnoreCase(option))) {
                return option;
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
                    .collect(Collectors.toList());

            if (!ingredientes.isEmpty()) {
                return ingredientes;
            }
            System.out.println("Debes agregar al menos un ingrediente.");
        }
    }

    private void confirmarSalida() {
        System.out.print("¿Seguro que quieres salir? (s/n): ");
        String respuesta = scanner.nextLine().trim();
        if (respuesta.equalsIgnoreCase("s")) {
            salir = true;
            System.out.println("Saliendo del sistema...");
        }
    }
}