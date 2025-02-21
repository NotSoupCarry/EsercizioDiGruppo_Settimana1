import java.util.ArrayList;
import java.util.Scanner;

public class Portale {

    static ArrayList<ArrayList<Object>> utenti = new ArrayList<>();
    static ArrayList<Double> calcoliEffettuati = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Portale portale = new Portale();

        System.out.println("\n*** BENVENUTO SU CALCOLATORE MAXIMUM DECIMUS MERIDIUM ***");
        while (true) {
            System.out.println("\n1. Registrati");
            System.out.println("2. Login");
            System.out.println("3. Esci");
            System.out.print("Scelta: ");
            int scelta = controlloInputInteri(scanner);

            switch (scelta) {
                case 1:
                    portale.registrazione(scanner);
                    break;
                case 2:
                    portale.login(scanner);
                    break;
                case 3:
                    System.out.println("Chiusura programma...");
                    return;
                default:
                    System.out.println("Scelta non valida!");
            }
        }
    }

    public static int controlloInputInteri(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Devi inserire un numero intero. Riprova: ");
            scanner.next();
        }
        int valore = scanner.nextInt();
        scanner.nextLine(); 
        return valore;
    }

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

    public void registrazione(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = controlloInputStringhe(scanner);

        System.out.print("Password: ");
        String password = controlloInputStringhe(scanner);

        System.out.print("Età: ");
        int eta = controlloInputInteri(scanner);

        System.out.print("Email: ");
        String email = controlloInputStringhe(scanner);

        ArrayList<Object> utente = new ArrayList<>();
        utente.add(nome);
        utente.add(password);
        utente.add(eta);
        utente.add(email);

        utenti.add(utente); 

        System.out.println("Registrazione completata con successo!");
    }

    public void login(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = controlloInputStringhe(scanner);

        System.out.print("Password: ");
        String password = controlloInputStringhe(scanner);

        for (int i = 0; i < utenti.size(); i++) {
            ArrayList<Object> utente = utenti.get(i);
            if (utente.get(0).equals(nome) && utente.get(1).equals(password)) {
                System.out.println("Login effettuato con successo! Benvenuto, " + nome);
                gestisciProfilo(scanner, i);
                return;
            }
        }
        System.out.println("Nome utente o password errati. Riprova.");
    }

    public static void gestisciProfilo(Scanner scanner, int indice) {
        while (true) {
            System.out.println("\n1. Modifica profilo");
            System.out.println("2. Calcolatrice");
            System.out.println("3. Inventario");
            System.out.println("4. Esci");
            System.out.print("Scelta: ");
            int scelta = controlloInputInteri(scanner);

            switch (scelta) {
                case 1:
                    modificaUtente(indice, scanner);
                    break;
                case 2:
                    calcolatrice(calcoliEffettuati);
                    break;
                case 3:
                    inventario(calcoliEffettuati);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Scelta non valida!");
            }
        }
    }

    public static void modificaUtente(int indice, Scanner scanner) {
        if (indice < 0 || indice >= utenti.size()) {
            System.out.println("Indice non valido! Nessun utente trovato.");
            return;
        }

        ArrayList<Object> utente = utenti.get(indice);

        System.out.print("Nuovo nome: ");
        utente.set(0, controlloInputStringhe(scanner));

        System.out.print("Nuova email: ");
        utente.set(3, controlloInputStringhe(scanner));

        System.out.print("Nuova età: ");
        utente.set(2, controlloInputInteri(scanner));

        System.out.println("Dati aggiornati con successo!");
    }

    public static void calcolatrice(ArrayList<Double> calcoliEffettuati) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println(
                    "Vuoi effettuare un'operazione? (1 - Addizione, 2 - Sottrazione, 3 - Moltiplicazione, 4 - Divisione, -1=Esci): ");
            int scelta = controlloInputInteri(input);

            if (scelta == -1) {
                System.out.println("Uscita dalla calcolatrice");
                break;
            }

            System.out.print("Inserisci primo numero: ");
            double num1 = input.nextDouble();
            System.out.print("Inserisci secondo numero: ");
            double num2 = input.nextDouble();

            double risultato = 0;
            switch (scelta) {
                case 1:
                    risultato = num1 + num2;
                    break;
                case 2:
                    risultato = num1 - num2;
                    break;
                case 3:
                    risultato = num1 * num2;
                    break;
                case 4:
                    if (num2 == 0) {
                        System.out.println("Errore: Divisione per zero non consentita.");
                        continue;
                    }
                    risultato = num1 / num2;
                    break;
                default:
                    System.out.println("Scelta non valida.");
                    continue;
            }

            System.out.println("Risultato: " + risultato);
            calcoliEffettuati.add(risultato);
        }
    }

    public static void inventario(ArrayList<Double> calcoliEffettuati) {
        if (calcoliEffettuati.isEmpty()) {
            System.out.println("Nessuna operazione salvata!");
            return;
        }
        for (int i = 0; i < calcoliEffettuati.size(); i++) {
            System.out.println("Operazione " + (i + 1) + " -> Risultato: " + calcoliEffettuati.get(i));
        }
    }
}
