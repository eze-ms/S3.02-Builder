package gm.controller;

import gm.model.Pizza;
import gm.service.MestrePizzer;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner;
    private final GestorPizzas gestorPizzas;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.gestorPizzas = new GestorPizzas(scanner);
    }

    public void mostrarMenu() {
        while (true) {
            System.out.println("\nMenú - Crear tu Pizza:");
            System.out.println("1. Pizza Hawaiana");
            System.out.println("2. Pizza Vegetariana");
            System.out.println("3. Crear pizza personalizada");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            int opcion = obtenerOpcion();
            if (opcion == 4) {
                if (confirmarSalida()) {
                    salir();
                }
                continue;
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
        Pizza.PizzaBuilder builder = Pizza.builder();
        MestrePizzer mestre = new MestrePizzer();
        mestre.setBuilder(builder);

        switch (tipo) {
            case 1 -> gestorPizzas.prepararPizzaHawaiana(builder);
            case 2 -> gestorPizzas.prepararPizzaVegetariana(builder);
            case 3 -> gestorPizzas.configurarPizzaPersonalizada(builder);
            default -> System.out.println("Opción inválida. Inténtalo de nuevo.");
        }

        Pizza pizza = mestre.hacerPizza();
        System.out.println("\nTu pizza ha sido creada con éxito:");
        System.out.println(pizza);
    }

    private boolean confirmarSalida() {
        System.out.print("¿Seguro que quieres salir? (s/n): ");
        String respuesta = scanner.nextLine().trim().toLowerCase();
        return respuesta.equals("s");
    }

    private void salir() {
        System.out.println("Saliendo del sistema...");
        scanner.close();
        System.exit(0);
    }
}
