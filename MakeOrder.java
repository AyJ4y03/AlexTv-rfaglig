package PizzaProgram;

import java.util.ArrayList;
import java.util.Scanner;

public class MakeOrder {
        private String name;
        private ArrayList<Pizza> pizzas;

        public MakeOrder(String name) {
                this.name = name;
                this.pizzas = new ArrayList<>();
        }

        public void addPizza(int orderNumber, int value) {
                Pizza newPizza = new Pizza(orderNumber, value);
                pizzas.add(newPizza);
        }

        public String toString() {
                String orderDetails = "Navn: " + name + "\nPizzaer:\n";
                for (Pizza pizza : pizzas) {
                        orderDetails += "Ordre nummer: " + pizza.getOrderNumber()
                                + ", Antal: " + pizza.getValue() + " stk.\n";
                }
                return orderDetails;
        }

        public static class Pizza {
                private int orderNumber;
                private int value;

                public Pizza(int orderNumber, int value) {
                        this.orderNumber = orderNumber;
                        this.value = value;
                }

                public int getOrderNumber() {
                        return orderNumber;
                }

                public int getValue() {
                        return value;
                }
        }

        public static void IndtastOrdre() {
                Scanner input = new Scanner(System.in);

                System.out.print("Indtast navn: ");
                String name = input.nextLine();

                MakeOrder newOrder = new MakeOrder(name);

                boolean addingPizza = true;
                while (addingPizza) {
                        System.out.print("Indtast pizza nr.: ");
                        int orderNumber = input.nextInt();

                        System.out.print("Indtast antal pizzaer: ");
                        int value = input.nextInt();

                        newOrder.addPizza(orderNumber, value);

                        System.out.println("Vil du fortsætte ordre? (Ja(1) Nej(2) Tilføj krav(3)):): ");
                        System.out.print("(1/2/3): ");
                        int choice = input.nextInt();
                        input.nextLine();

                        if (choice == 2) {
                                addingPizza = false;
                        }
                }

                System.out.println("\nKvittering:");
                System.out.println(newOrder);
        }
}
