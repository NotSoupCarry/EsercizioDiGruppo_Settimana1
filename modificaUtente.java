import java.util.ArrayList;
import java.util.Scanner;

public class ModificaUtente {

    // ArrayList contenente gli utenti, ciascuno rappresentato come un ArrayList di
    // Object
    ArrayList<ArrayList<Object>> utenti = new ArrayList<>();

    // Metodo per modificare i dati dell'utente (nome, email ed età) dopo il login
    public void modificaUtente(String nome, Scanner scanner) {
        // Itera su ogni utente presente nell'ArrayList 'utenti'
        for (ArrayList<Object> utente : utenti) {
            // Controlla se il nome dell'utente (posizione 0) corrisponde al nome fornito
            if (utente.get(0).equals(nome)) {
                System.out.print("Nuovo nome: ");
                // Modifica il nome dell'utente, sostituendo il valore alla posizione 0
                utente.set(0, controlloInputStringhe(scanner));

                System.out.print("Nuova email: ");
                // Modifica l'email dell'utente, sostituendo il valore alla posizione 3
                utente.set(3, controlloInputStringhe(scanner));

                System.out.print("Nuova età: ");
                // Modifica l'età dell'utente alla posizione 2, convertendo l'input in intero
                utente.set(2, (controlloInputInteri(scanner)));

                System.out.println("Dati aggiornati con successo!");
                return; // Esce dal metodo una volta aggiornato l'utente
            }
        }
        // Se nessun utente corrisponde al nome fornito, viene mostrato un messaggio di
        // errore
        System.out.println("Utente non trovato!");
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
