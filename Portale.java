import java.util.ArrayList;
import java.util.Scanner;

public class Portale {

    ArrayList<ArrayList<Object>> utenti = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n*** BENVENUTO SU CALCOLATORE MAXIMUM DECIMUS MERIDIUM***");
        while (true) {
            // Menu principale
            System.out.println("\n1. Registrati");
            System.out.println("2. Login");
            System.out.println("3. Esci");
            System.out.print("Scelta: ");
            int scelta = controlloInputInteri(scanner); // Chiede la scelta dell'utente

            switch (scelta) {
                case 1:
                    // registrazione(scanner); // Registrazione dell'utente
                    break;
                case 2:
                    // login(scanner); // Login dell'utente
                    break;
                case 3:
                    System.out.println("Funzionalità");
                    return; // Esce dal programma
                default:
                    System.out.println("Scelta non valida!"); // Gestisce la scelta non valida
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
        } while (valore < 0); // Continua a chiedere se il valore è negativo
        return valore; // Restituisce l'input valido
    }

    // Metodo per controllare che l'input stringa non sia vuoto
    public static String controlloInputStringhe(Scanner scanner) {
        String valore;
        do {
            valore = scanner.nextLine().trim(); // Rimuove gli spazi superflui
            if (valore.isEmpty()) {
                System.out.print("Input non valido. Inserisci un testo: ");
            }
        } while (valore.isEmpty()); // Continua a chiedere se la stringa è vuota
        return valore; // Restituisce l'input valido
    }
}

