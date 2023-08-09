
import java.util.Random;
import java.util.Scanner;

public class Oasistask2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int maxAttempts = 5;

        int score = 0;
        int rounds = 0;

        System.out.println("Welcome to Guess the Number!");
        System.out.println("You have " + maxAttempts + " attempts per round.");

        char playAgain;
        do {
            int targetNumber = random.nextInt(100) + 1;
            int attempts = 0;

            System.out.println("\nRound " + (++rounds) + ": Guess a number between 1 and 100");

            while (attempts < maxAttempts) {
                System.out.print("Attempt #" + (attempts + 1) + ": Enter your guess: ");
                int guess = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                if (guess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number.");
                    int points = maxAttempts - attempts;
                    score += points;
                    System.out.println("You earned " + points + " points in this round.");
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

                attempts++;
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you ran out of attempts. The number was " + targetNumber + ".");
            }

            System.out.print("Do you want to play again? (y/n): ");
            playAgain = scanner.nextLine().charAt(0);
        } while (playAgain == 'y' || playAgain == 'Y');

        System.out.println("\nGame Over!");
        System.out.println("Your final score: " + score);
        scanner.close();
    }
}
