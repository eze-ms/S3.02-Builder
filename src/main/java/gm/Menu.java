package gm;

import gm.builder.HawaiianPizzaBuilder;
import gm.builder.PizzaBuilder;
import gm.builder.VegetarianPizzaBuilder;
import gm.model.Pizza;
import gm.service.MestrePizzer;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Menu {
    private final Scanner scanner;

    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("\nMenú - Crear tu Pizza:");
            System.out.println("1. Pizza Hawaiana");
            System.out.println("2. Pizza Vegetariana");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            int opcion = obtenerOpcion();
            if (opcion == 3) {
                salir();
            }

            construirPizza(opcion);
        }
    }

    private int obtenerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: Ingresa un número válido.");
            return -1;
        }
    }

    private void construirPizza(int tipo) {
        Supplier<PizzaBuilder> pizzaSupplier = switch (tipo) {
            case 1 -> HawaiianPizzaBuilder::new;
            case 2 -> VegetarianPizzaBuilder::new;
            default -> {
                System.out.println("Opción inválida. Inténtalo de nuevo.");
                yield null;
            }
        };

        if (pizzaSupplier == null) return;
        configurarPizza(pizzaSupplier.get());
    }

    private void configurarPizza(PizzaBuilder builder) {
        System.out.print("Elige el tamaño (Small, Medium, Large): ");
        builder.setSize(scanner.nextLine());

        System.out.print("Elige el tipo de masa (Thin, Thick, Stuffed): ");
        builder.setDough(scanner.nextLine());

        System.out.println("Ingredientes base: " + builder.build().getToppings());
        System.out.print("¿Quieres agregar ingredientes extra? (s/n): ");
        if (scanner.nextLine().equalsIgnoreCase("s")) {
            agregarIngredientesExtra(builder);
        }

        MestrePizzer mestre = new MestrePizzer(builder);
        Pizza pizza = mestre.makePizza();

        if (pizza != null) {
            System.out.println("\nTu pizza ha sido creada con éxito:");
            System.out.println(pizza);
        }
    }

    private void agregarIngredientesExtra(PizzaBuilder builder) {
        System.out.print("Ingresa los ingredientes separados por comas: ");
        List<String> extraToppings = Arrays.stream(scanner.nextLine().split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        builder.setToppings(extraToppings);
    }

    private void salir() {
        System.out.println("Saliendo del sistema...");
        scanner.close();
        System.exit(0);
    }
}
