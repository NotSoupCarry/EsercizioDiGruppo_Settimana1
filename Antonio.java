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
                    "Vuoi effettuare un'operazione? (1 - Addizione, 2 - Sottrazione, 3 - Moltiplicazione, 4 - Divisione, -1=Esci): ");
            double scelta = input.nextDouble();

            if (scelta == -1) {
                System.out.println("Uscita dalla calcolatrice");
                break;
            } else if (scelta == 1) {
                // Prendo gli operandi dell'operazione
                System.out.println("Aggiungi addendo1: ");
                double addendo1 = input.nextDouble();
                input.next();

                System.out.println("Aggiungi addendo2: ");
                double addendo2 = input.nextDouble();
                input.next();

                operazione = addendo1 + addendo2;
                System.out.println("Risultato addizione: " + operazione);

                // Aggiunta risultato all'arraylist
                calcoliEffettuali.add(operazione);

            } else if (scelta == 2) {
                // Prendo gli operandi dell'operazione
                System.out.println("Aggiungi sottraendo1: ");
                double sottraendo1 = input.nextDouble();
                input.next();

                System.out.println("Aggiungi sottraendo2: ");
                double sottraendo2 = input.nextDouble();
                input.next();

                operazione = sottraendo1 - sottraendo2;
                System.out.println("Risultato sottraendo: " + operazione);

                // Aggiunta risultato all'arraylist
                calcoliEffettuali.add(operazione);

            } else if (scelta == 3) {
                // Prendo gli operandi dell'operazione
                System.out.println("Aggiungi fattore1: ");
                double fattore1 = input.nextDouble();
                input.next();

                System.out.println("Aggiungi fattore2: ");
                double fattore2 = input.nextDouble();
                input.next();

                operazione = fattore1 * fattore2;
                System.out.println("Risultato moltiplicazione: " + operazione);

                // Aggiunta risultato all'arraylist
                calcoliEffettuali.add(operazione);

            } else if (scelta == 4) {
                // Prendo gli operandi dell'operazione
                System.out.println("Aggiungi dividendo: ");
                double dividendo = input.nextDouble();
                input.next();

                System.out.println("Aggiungi divisore: ");
                double divisore = input.nextDouble();
                input.next();

                // Evita la divisione per zero
                while (divisore == 0) {
                    System.out.println("Errore: Il divisore non può essere zero! Inserisci un altro numero:");
                    divisore = input.nextDouble();
                    input.next();
                }
                operazione = dividendo / divisore;
                System.out.println("Risultato divisione: " + operazione);

                // Aggiunta risultato all'arraylist
                calcoliEffettuali.add(operazione);

            } else {
                System.out.println("Inserisci un numero tra 1 e 4 o -1 per uscire.");
            }
        }
        // Chiusura scanner
        input.close();
    }

    // Funzione per visualizzare tutti i calcoli precedenti
    public static void inventario(ArrayList<Double> calcoliEffettuati) {
        if (calcoliEffettuati.isEmpty()) {
            System.out.println("Nessuna operazione salvata!");
            return;
        }
        // Ciclo per la stampa dei calcoli effettuati in precedenza
        for (int i = 1; i <= calcoliEffettuati.size(); i++) {
            System.out.println("Operazione " + i + " -> Risultato: " + calcoliEffettuati.get(i));
        }
    }

}