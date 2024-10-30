package PizzaProgram;

import java.util.ArrayList;

public class SeeOrder {
    // liste til at gemme alle færdige ordrer
    public static ArrayList<MakeOrder> allOrders = new ArrayList<>();

    // Metode til at vise alle gemte ordrer
    public static void seeOrders() {
        System.out.println("--- Alle Ordre ---");
        if (allOrders.isEmpty()) {
            System.out.println("Ingen ordrer fundet.");
        } else {
            for (MakeOrder order : allOrders) {
                System.out.println("Ordre for: " + order.name);
                for (ValuesOfPizza pizza : order.pizzas) {
                    System.out.println(pizza.pizzaToString());
                }
                System.out.println("Total Pris: " + order.totalPrice + " kr\n");
            }
        }
    }
}
