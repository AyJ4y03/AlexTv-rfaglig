package PizzaProgram;

import java.util.ArrayList;
import java.util.Scanner;

public class MakeOrder {
        // Attributes:
        public String name; // Navnet på kunden
        public int totalPrice; // Den endelige pris når en ordre er færdiggjort
        public ArrayList<ValuesOfPizza> pizzas; // Liste over ordren

        // Setters for ordre liste og total pris
        public MakeOrder() {
                this.pizzas = new ArrayList<>(); // Setter en arrayliste til pizzas
                this.totalPrice = 0; // setter total pris til 0
        }

        // Metode til at tilføje en pizza til ordren
        public void addPizzaToOrder(ValuesOfPizza pizza) {
                Scanner scanner = new Scanner(System.in);

                // Spørg om man vil tilføje krav til pizza:
                System.out.println("Vil du tilføje krav til " + pizza.navn + "? (Ja(1) / Nej(2):): ");
                System.out.print("(1/2): ");
                int krav = scanner.nextInt();
                scanner.nextLine();

                if (krav == 1) {
                        System.out.print("Tilføj krav: ");
                        String extraKrav = scanner.nextLine();
                        pizza.ingredienser += ", Ekstra: " + extraKrav;
                }

                pizzas.add(pizza);
                totalPrice += pizza.pris;
                System.out.println("Tilføjet til ordre: " + pizza.pizzaToString());
        }

        // Metode til at vise den fulde ordre og indtaste kundens navn
        public void showOrder() {
                Scanner scanner = new Scanner(System.in);

                System.out.println("\n--- Ordre Liste ---");
                for (ValuesOfPizza pizza : pizzas) {
                        System.out.println(pizza.pizzaToString());
                }
                System.out.println("Total Pris: " + totalPrice + " kr");

                // Indtast kundens navn
                System.out.print("Kundens navn: ");
                this.name = scanner.nextLine();
                System.out.println("Ordre færdiggjort for: " + name);

                SeeOrder.allOrders.add(this);
        }

        // Metode til at lave en ordre fra menuen
        public static void createOrderFromMenu() {
                Scanner scanner = new Scanner(System.in);
                MakeOrder order = new MakeOrder();

                System.out.println("Tilgængelige Pizzaer: ");
                for (int i = 0; i < ValuesOfPizza.menyPizza.size(); i++) {
                        System.out.println((i + 1) + ". " + ValuesOfPizza.menyPizza.get(i).pizzaToString());
                }

                int choice;
                do {
                        System.out.println("Skriv (0) for at afslutte ordre!");
                        System.out.print("Skriv nummer på pizza: ");

                        // Tjek om input er et tal
                        while (!scanner.hasNextInt()) {
                                System.out.println("Ugyldigt input. Indtast et pizzanummer eller 0 for at afslutte.");
                                scanner.next();
                        }

                        choice = scanner.nextInt();

                        if (choice != 0) {
                                int pizzaChoice = choice - 1; // Justere for  et nul-baseret indeks
                                if (pizzaChoice >= 0 && pizzaChoice < ValuesOfPizza.menyPizza.size()) {
                                        order.addPizzaToOrder(ValuesOfPizza.menyPizza.get(pizzaChoice));
                                } else {
                                        System.out.println("Ugyldigt valg. Vælg et gyldigt pizzanummer.");
                                }
                        }
                } while (choice != 0);
                order.showOrder();
        }
}
