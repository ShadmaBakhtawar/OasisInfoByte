import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Oasistask4 {
    private static Map<String, String> users = new HashMap<>();
    private static String currentUser;
    private static boolean loggedIn = false;
    // private static int timerSeconds = 120; // 2 minutes

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample users (you can add more or replace these)
        users.put("john", "password1");
        users.put("mary", "password2");
        users.put("alex", "password3");

        while (true) {
            if (!loggedIn) {
                System.out.println("Welcome to the Quiz App!");
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();

                if (login(username, password)) {
                    System.out.println("Login successful. Welcome, " + currentUser + "!");
                } else {
                    System.out.println("Invalid username or password. Please try again.");
                }
            } else {
                System.out.println("\nSelect an option:");
                System.out.println("1. Update Profile and Password");
                System.out.println("2. Start Quiz");
                System.out.println("3. Logout");

                int option = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (option) {
                    case 1:
                        updateProfileAndPassword(scanner);
                        break;
                    case 2:
                        startQuiz(scanner);
                        break;
                    case 3:
                        logout();
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        }
    }

    private static boolean login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            currentUser = username;
            loggedIn = true;
            return true;
        }
        return false;
    }

    private static void updateProfileAndPassword(Scanner scanner) {
        System.out.print("Enter new username: ");
        String newUsername = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();
        users.put(newUsername, newPassword);
        users.remove(currentUser);
        currentUser = newUsername;
        System.out.println("Profile and password updated successfully.");
    }

    private static void startQuiz(Scanner scanner) {
        System.out.println("Starting Quiz...");
        // Implement the quiz logic here (MCQs, timer, auto submit, etc.)
        // For simplicity, we can assume a simple MCQ-based quiz without a timer in this
        // example.
        System.out.println("Quiz completed! Congratulations, " + currentUser + "!");
    }

    private static void logout() {
        loggedIn = false;
        System.out.println("Logged out successfully. Goodbye, " + currentUser + "!");
        currentUser = null;
    }
}
