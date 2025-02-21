import java.util.ArrayList;
import java.util.Scanner;

public class Antonio {

    // Creazione arraylist per l'inventario dei calcoli effettuati
    ArrayList<Double> calcoliEffettuali = new ArrayList<>();

    // Funzione per la calcolatrice
    public static void calcolatrice(ArrayList<Double> calcoliEffettuali) {
        // Apertura scanner
        Scanner input = new Scanner(System.in);
        // Variabile per salvare l'operazione nell'arraylist
        double operazione = 0;

        while (true) {
            System.out.println(
                    "Scegli un'operazione (1 - Addizione, 2 - Sottrazione, 3 - Moltiplicazione, 4 - Divisione, -1=Esci): ");
            double scelta = input.nextDouble();

            if (scelta == -1) {
                System.out.println("Uscita dalla calcolatrice");
                break;
            } else if (scelta == 1) {
                System.out.println("Aggiungi addendo1: ");
                double addendo1 = input.nextDouble();
                System.out.println("Aggiungi addendo2: ");
                double addendo2 = input.nextDouble();
                operazione = addendo1 + addendo2;
                System.out.println("Risultato addizione: " + operazione);
                calcoliEffettuali.add(operazione);

            } else if (scelta == 2) {
                System.out.println("Aggiungi sottraendo1: ");
                double sottraendo1 = input.nextDouble();
                System.out.println("Aggiungi sottraendo2: ");
                double sottraendo2 = input.nextDouble();
                operazione = sottraendo1 - sottraendo2;
                System.out.println("Risultato sottraendo: " + operazione);
                calcoliEffettuali.add(operazione);

            } else if (scelta == 3) {
                System.out.println("Aggiungi fattore1: ");
                double fattore1 = input.nextDouble();
                System.out.println("Aggiungi fattore2: ");
                double fattore2 = input.nextDouble();
                operazione = fattore1 * fattore2;
                System.out.println("Risultato moltiplicazione: " + operazione);
                calcoliEffettuali.add(operazione);

            } else if (scelta == 4) {
                System.out.println("Aggiungi dividendo: ");
                double dividendo = input.nextDouble();
                System.out.println("Aggiungi divisore: ");
                double divisore = input.nextDouble();

                while (divisore == 0) { // Evita la divisione per zero
                    System.out.println("Errore: Il divisore non può essere zero! Inserisci un altro numero:");
                    divisore = input.nextDouble();
                }
                operazione = dividendo / divisore;
                System.out.println("Risultato divisione: " + operazione);
                calcoliEffettuali.add(operazione);

            } else {
                System.out.println("Inserisci un numero tra 1 e 4 o -1 per uscire.");
            }
        }
        // Chiusura scanner
        input.close();
    }

    public static void inventario(ArrayList<Double> calcoliEffettuati) {
        if (calcoliEffettuati.isEmpty()) {
            System.out.println("Nessuna operazione salvata!");
            return;
        }

        for (int i = 1; i <= calcoliEffettuati.size(); i++) {
            System.out.println("Operazione " + i + " -> Risultato: " + calcoliEffettuati.get(i));
        }
    }

}