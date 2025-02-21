# EsercizioDiGruppo_Settimana1
import java.util.Arraylist;

public class Eserciziogruppo {
    static Scanner scanner = new Scanner(System.in);
    static List<Utente> utenti = new ArrayList<>();
    static Utente utenteLoggato = null;
    static int idCounter = 1;
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Registrazione\n2. Login\n3. Esci");
            int scelta = leggiIntero();
            switch (scelta) {
                case 1 -> registrazione();
                case 2 -> login();
                case 3 -> {
                    System.out.println("Uscita dal programma.");
                    return;
                }
                default -> System.out.println("Scelta non valida.");
            }
        }
    }
    
    static void registrazione() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Età: ");
        int eta = leggiIntero();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        
        Utente nuovoUtente = new Utente(idCounter++, nome, password, eta, email);
        utenti.add(nuovoUtente);
        System.out.println("Registrazione completata! Il tuo ID è: " + nuovoUtente.id);
    }
    
    static void login() {
        System.out.print("ID: ");
        int id = leggiIntero();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        
        for (Utente u : utenti) {
            if (u.id == id && u.password.equals(password)) {
                utenteLoggato = u;
                System.out.println("Login effettuato con successo!");
                menuUtente();
                return;
            }
        }
        System.out.println("Credenziali errate.");
    }
 
   
