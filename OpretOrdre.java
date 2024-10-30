package PizzaProgram;

import java.util.Scanner;
import static PizzaProgram.ValuesOfPizza.menyPizza;
import java.util.ArrayList;
//den her lavede jeg i går, her er opret ordre, omsætning, dagens tab og alt det her. kan lige vise den. I princippet,
// Så er der en masse arraylister, hvor informationer bliver kastet frem og tilbage, det gør at den kan gemme nogen informationer og nulstille andre informationer
//råb lige op hvis i har et spørgsmål eller jeg skal forklare noget

public class OpretOrdre {
    public static int ordreNummerTæller;
    public int ordreNummerKø;
    public int pizzaOrdreAntal;
    public int ordreTotalPris;
    public int givenPizzaPris;
    public int samletPris;
    public String valgtPizza;
    public static ArrayList<String> pizzaOrdreNavne = new ArrayList<String>();
    public static ArrayList<Integer> pizzaOrdrePris = new ArrayList<Integer>();
    public static ArrayList<Integer> pizzaOrdreAntalArr = new ArrayList<Integer>();
    public static ArrayList<String> ordreLinje1 = new ArrayList<String>();
    public static ArrayList<String> kundeNavn = new ArrayList<String>();
    String kundeNavnSlut;
    public static ArrayList<Integer> betaling = new ArrayList<Integer>();
    public int omsætningSlut;
    public int dagensTabSlut;
    int kundeNummerST;


    public OpretOrdre() {
        this.pizzaOrdreAntal = 0;
        this.ordreTotalPris = 0;
        this.givenPizzaPris = 0;
        this.samletPris = 0;
        this.ordreNummerKø = ordreNummerTæller++;;
    }

    public void tilføjPizza() {
        System.out.println("\nIndtast et navn tilknyttet til ordren:");
        Scanner scNavnKunde = new Scanner(System.in);
        String scNavnKundeInput = scNavnKunde.nextLine();
        kundeNavnSlut = scNavnKundeInput;
        //kundeNavn.add(scNavnKundeInput);

        boolean flerePizzaer = true;
        while (flerePizzaer) {
            ValuesOfPizza.visAllePizzaer(); // her får man en liste over de 30 pizzaer i systemet, og man skriver nr på den man vil have
            System.out.println("Indtast nummeret på den pizza du vil tilføje til ordren");
            Scanner scOrdre = new Scanner(System.in);
            int scOrdreInput = scOrdre.nextInt() - 1;
            valgtPizza = menyPizza.get(scOrdreInput).navn;

            System.out.println("Du har valgt: " + valgtPizza); // hertilføjer den den valgte pizza, gemmer det til betaling
            pizzaOrdreNavne.add(valgtPizza);
            givenPizzaPris = menyPizza.get(scOrdreInput).pris;
            pizzaOrdrePris.add(givenPizzaPris);


            System.out.println("Hvor mange gange vil du tilføje den givne pizza?"); // hvor mange vil man have af den givne pizza
            Scanner scOrdreAntal = new Scanner(System.in);
            int scOrdreAntalInput = scOrdreAntal.nextInt();
            pizzaOrdreAntal = scOrdreAntalInput;
            pizzaOrdreAntalArr.add(pizzaOrdreAntal);

            ordreTotalPris = pizzaOrdreAntal * givenPizzaPris;

            System.out.println("Du har valgt: " + pizzaOrdreAntal + " styks " + valgtPizza + " som koster: " + givenPizzaPris + " kr stk");
            System.out.println("Prisen er derfor: " + ordreTotalPris + " kr");
            samletPris += ordreTotalPris;

            System.out.println("Ønsker du at tilføje flere pizzaer til ordren? Tast 1 for ja, 2 for nej."); // her kan man tilføje flere pizzaer til ordren, altså andre pizzaer
            Scanner scPizzaFlere = new Scanner(System.in);
            int scPizzaFlereInput = scPizzaFlere.nextInt();
            if (scPizzaFlereInput == 1) {
                System.out.println(" ");
            } else {
                flerePizzaer = false;
            }


        }
        System.out.println("Du har valgt følgende pizzaer: " + pizzaOrdreNavne);
        System.out.println("De er blevet valgt i følgende antal: " + pizzaOrdreAntalArr); //jeg vil gerne ændre på, hvordan layout ser ud, fordi det ser lidt scuffed ud, når den printer, jeg kan lige vise det til marcus bagefter siden han missede den færste del
        System.out.println("Den samlede pris er: " + samletPris + " kr");

        boolean kassereOrdre = true;
        while (kassereOrdre) {
            System.out.println("Ønsker du at tilføje denne ordre til ordrelinje eller skal den kasseres?"); //her spørger den om den skal være på ordrelinjen eller man vil kassere den.
            System.out.println("Tast 1 for at tilføje den, 2 for at kassere den:");
            Scanner scKassere = new Scanner(System.in);
            int scKassereInput = scKassere.nextInt();
            if (scKassereInput == 1) {
                ordreNummerKø++; // her får den et ordrenummer, den skal lige ændres lidt på
                ordreLinje1.add("Kundens Navn: " + kundeNavnSlut +
                        "\nOrdre Nummer: " + ordreNummerKø + "." +
                        "\nPizzaer:");

                for (int i = 0; i < pizzaOrdreNavne.size(); i++) { // For loop til at gå igennem de to arrays
                    String pizzaInfo = pizzaOrdreNavne.get(i) + ": " + pizzaOrdreAntalArr.get(i);
                    ordreLinje1.add(pizzaInfo);
                }
                ordreLinje1.add("Total Pris: " + prisToString() + " kr\n");

                betaling.add(samletPris);

                kassereOrdre = false;

            } else if (scKassereInput == 2) {
                System.out.println("Du har valgt ikke at gemme ordren."); // her kan man vælge ikke at gemme ordren
                kassereOrdre = false;

            } else {
                System.out.println("det forstod jeg ikke, prøv igen");
            }
            pizzaOrdreAntalArr.clear();
            pizzaOrdreNavne.clear();
            pizzaOrdrePris.clear();
            this.pizzaOrdreAntal = 0;
            this.ordreTotalPris = 0;
            this.givenPizzaPris = 0;
            this.samletPris = 0;
            kundeNavnSlut = "";
            // her nustiller den/clearer de variabler og arrays som er blevet brugt, fordi ellers ville man ikke kunne lave ny ordre.
        }

    }
    //de to metoder nedenunder, laver en integer arrListe og en int til String
    public String antalToString(){
        return " " + pizzaOrdreAntalArr;
    }
    public String prisToString(){
        return " " + samletPris;
    }

    //den viser den nuværende ordrelinje
    public void visOrdrelinje(){
        System.out.println("\n --- Ordre Liste ---");
        for (String ordre : ordreLinje1) { // For loop til at vise ordrene en efter en
            System.out.println(ordre);
        }
    }

    //her kan man færdiggøre en ordre. 3 muligheder, tilføj til dagens salg, dagens tab eller bare annullere ordren.
    public void finishOrder(){
        boolean funkValg = true;
        boolean funkValg1 = true;
        while(funkValg) {
            System.out.println("Hvilken funktion ønsker du? " +
                    "\nTast 1 for betaling og færdiggøre en ordre " +
                    "\nTast 2 for at fjerne en ordre fra ordrelinjen" +
                    "\nTast 3 for at tilføje en ordre til dagens tab");
            Scanner scFunk = new Scanner(System.in);
            int scFunkInput = scFunk.nextInt();
            if(scFunkInput == 1){
                System.out.println("Hvilken ordre skal færdiggøres?");
                visOrdrelinje();
                Scanner scFinish = new Scanner(System.in);
                int scFinishInput = scFinish.nextInt();
                System.out.println("Du har valgt: " + ordreLinje1.get(scFinishInput -1));
                System.out.println("Kunden skal betale: " + betaling.get(scFinishInput-1) + " kr");
                System.out.println("Har kunden betalt? " +
                        "\nTast 1 for ja, hvilket vil færdiggøre ordren." +
                        "\nTast 2 for nej, hvilket vil gå tilbage til ordremenuen.");
                while(funkValg1) {
                    Scanner scDone = new Scanner(System.in);
                    int scDoneInput = scDone.nextInt();
                    if (scDoneInput == 1) {
                        System.out.println("Du har valgt at kunden har betalt");
                        omsætningSlut += betaling.get(scFinishInput-1);
                        ordreLinje1.remove(ordreLinje1.get(scFinishInput -1));
                        funkValg1 = false;
                    } else if (scDoneInput == 2) {
                        System.out.println("Du valgte at kunden ikke har betalt");
                        funkValg1 = false;
                    } else {
                        System.out.println("Det forstod jeg ikke, prøv igen");
                    }
                }


                funkValg = false;
            } else if (scFunkInput == 2){
                System.out.println("Hvilken ordre skal annulleres fra ordrelinjen?");
                visOrdrelinje();
                Scanner scFinish1 = new Scanner(System.in);
                int scFinishInput1 = scFinish1.nextInt();
                System.out.println("Du har valgt: " + ordreLinje1.get(scFinishInput1 -1));
                ordreLinje1.remove( ordreLinje1.get(scFinishInput1 -1));

                funkValg = false;
            } else if (scFunkInput == 3){
                System.out.println("Hvilken ordre skal tilføjes til dagens tab?");
                visOrdrelinje();
                Scanner scTab = new Scanner(System.in);
                int scTabInput = scTab.nextInt();
                System.out.println("Du har valgt: " + ordreLinje1.get(scTabInput -1));
                dagensTabSlut += betaling.get(scTabInput-1);
                ordreLinje1.remove( ordreLinje1.get(scTabInput -1));


                funkValg = false;
            } else {System.out.println("Det forstod jeg ikke, prøv igen"); }


        }



    }
// de her to viser omsætning og dagens tab
    public void omsætning(){
        System.out.println("Dagens omsætning er følgende: " + omsætningSlut + " kr");

    }

    public void dagensTab(){
        System.out.println("Dagen tab er følgende: " + dagensTabSlut + " kr");

    }


}
