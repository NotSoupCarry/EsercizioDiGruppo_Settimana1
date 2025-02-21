import java.util.ArrayList;
import java.util.Scanner;

public class Portale {

    ArrayList<ArrayList<Object>> utenti = new ArrayList<>();
    // Creazione arraylist per l'inventario dei calcoli effettuati
    static ArrayList<Double> calcoliEffettuali = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Portale portale = new Portale(); // Istanza della classe per gestire gli utenti

        System.out.println("\n*** BENVENUTO SU CALCOLATORE MAXIMUM DECIMUS MERIDIUM ***");
        while (true) {
            // Menu principale
            System.out.println("\n1. Registrati");
            System.out.println("2. Login");
            System.out.println("3. Esci");
            System.out.print("Scelta: ");
            int scelta = controlloInputInteri(scanner); // Chiede la scelta dell'utente

            switch (scelta) {
                case 1:
                    portale.registrazione(scanner); // Registrazione
                    break;
                case 2:
                    portale.login(scanner); // Login
                    break;
                case 3:
                    System.out.println("Chiusura programma...");
                    return; // Esce dal programma
                default:
                    System.out.println("Scelta non valida!"); // Gestisce scelte errate
            }
        }
    }

    // Metodo per controllare l'input intero
    public static int controlloInputInteri(Scanner scanner) {
        int valore;
        do {
            while (!scanner.hasNextInt()) {
                System.out.print("Devi inserire un numero intero. Riprova: ");
                scanner.next();
            }
            valore = scanner.nextInt();
            scanner.nextLine();
            if (valore < 0) {
                System.out.print("Il numero non può essere negativo. Riprova: ");
            }
        } while (valore < 0);
        return valore;
    }

    // Metodo per controllare che l'input stringa non sia vuoto
    public static String controlloInputStringhe(Scanner scanner) {
        String valore;
        do {
            valore = scanner.nextLine().trim();
            if (valore.isEmpty()) {
                System.out.print("Input non valido. Inserisci un testo: ");
            }
        } while (valore.isEmpty());
        return valore;
    }

    // Metodo per registrare un utente e salvarlo nella lista
    public void registrazione(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = controlloInputStringhe(scanner);

        System.out.print("Password: ");
        String password = controlloInputStringhe(scanner);

        System.out.print("Età: ");
        int eta = controlloInputInteri(scanner);

        System.out.print("Email: ");
        String email = controlloInputStringhe(scanner);

        // Creazione del profilo utente e aggiunta alla lista utenti
        ArrayList<Object> utente = new ArrayList<>();
        utente.add(nome);
        utente.add(password);
        utente.add(eta);
        utente.add(email);

        System.out.println("Registrazione completata con successo!");
    }

    // Metodo per il login
    public void login(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = controlloInputStringhe(scanner);

        System.out.print("Password: ");
        String password = controlloInputStringhe(scanner);
        int i = 0;
        // Controllo credenziali
        for (ArrayList<Object> utente : utenti) {
            if (utente.get(0).equals(nome) && utente.get(1).equals(password)) {
                System.out.println("Login effettuato con successo! Benvenuto, " + nome);
                i++;
                gestisciProfilo(scanner, i);
            }
        }
        System.out.println("Nome utente o password errati. Riprova.");
    }

    private static void gestisciProfilo(Scanner scanner, int indice) {
        boolean exitGestioneProfilo = false;
        while (!exitGestioneProfilo) {
            // Menu di gestione del profilo
            System.out.println("\n1. Modifica profilo");
            System.out.println("2. Calcolatrice");
            System.out.println("3. Inventario");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");
            int scelta = controlloInputInteri(scanner); // Controlla la scelta dell'utente

            switch (scelta) {
                case 1:
                    // modificaNome(scanner, indice); // Modifica del nome
                    break;
                case 2:
                    calcolatrice(calcoliEffettuali); // Modifica della password
                    break;
                case 3:
                    inventario(calcoliEffettuali); // Modifica della password
                    break;
                case 4:
                    exitGestioneProfilo = true; // Esce dalla gestione del profilo
                    return;
                default:
                    System.out.println("Scelta non valida!"); // Gestisce la scelta non valida
            }
        }
    }

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
