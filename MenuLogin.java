import java.util.Scanner;

public class MenuLogin {
    // Metodo per gestire le modifiche del profilo
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
