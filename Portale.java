import java.util.ArrayList;
import java.util.Scanner;

public class Portale {

    ArrayList<ArrayList<Object>> utenti = new ArrayList<>();

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
                    // calcolatrice(scanner, indice); // Modifica della password
                    break;
                case 3:
                    // Inventario(scanner, indice); // Modifica della password
                    break;
                case 4:
                    exitGestioneProfilo = true; // Esce dalla gestione del profilo
                    return;
                default:
                    System.out.println("Scelta non valida!"); // Gestisce la scelta non valida
            }
        }
    }

}
