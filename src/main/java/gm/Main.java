package gm;
public class Main {
    public static void main(String[] args) {
        // Construyendo una pizza hawaiana
        System.out.println("Construyendo una pizza Hawaiana...");
        PizzaBuilder builder = new HawaiianPizzaBuilder().setSize("Large").setDough("Thin");
        MestrePizzer mestre = new MestrePizzer(builder);
        Pizza pizza = mestre.makePizza();
        if (pizza != null) {
            System.out.println("Pizza Hawaiana construida:");
            System.out.println(pizza);
        }

        System.out.println();

        // Construyendo una pizza vegetariana
        System.out.println("Construyendo una pizza Vegetariana...");
        PizzaBuilder builderVeg = new VegetarianPizzaBuilder().setSize("Medium").setDough("Thick");
        MestrePizzer mestreVeg = new MestrePizzer(builderVeg);
        Pizza vegetarianPizza = mestreVeg.makePizza();
        if (vegetarianPizza != null) {
            System.out.println("Pizza Vegetariana construida:");
            System.out.println(vegetarianPizza);
        }
    }}
