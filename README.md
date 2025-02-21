import java.util.ArrayList;      
import java.util.Scanner;   

public class Eserciziodigruppo {
    static Scanner scanner = new Scanner(System.in); // Scanner per leggere gli input dell'utente
    static List<Utente> utenti = new ArrayList<>();  // Lista che memorizza gli utenti registrati
    static Utente utenteLoggato = null; // Variabile che memorizza l'utente attualmente loggato
    static int idCounter = 1; // Contatore per assegnare ID univoci agli utenti

    public static void main(String[] args) {
        // Ciclo infinito per mantenere il programma in esecuzione
        while (true) {
            // Menu principale con le opzioni disponibili
            System.out.println("1. Registrazione\n2. Login\n3. Esci");
            
            int scelta = leggiIntero(); // Legge la scelta dell'utente
            switch (scelta) {
                case 1 -> registrazione(); // Chiamata alla funzione di registrazione
                case 2 -> login();         // Chiamata alla funzione di login
                case 3 -> {                
                    System.out.println("Uscita dal programma."); 
                    return; // Termina il programma
                }
                default -> System.out.println("Scelta non valida."); // Gestisce input errati
            }
        }
    }

    static void registrazione() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine(); // Legge il nome dell'utente
        
        System.out.print("Password: ");
        String password = scanner.nextLine(); // Legge la password
        
        System.out.print("Età: ");
        int eta = leggiIntero(); // Legge l'età dell'utente
        
        System.out.print("Email: ");
        String email = scanner.nextLine(); // Legge l'email dell'utente

       

