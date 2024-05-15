import java.util.Scanner;
import java.util.Random;

public class NumberGuessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minRange = 1;
        int maxRange = 100;
        int attemptsLimit = 10;
        int totalAttempts = 0;

        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    int attempts = playGame(random, minRange, maxRange, attemptsLimit, scanner);
                    totalAttempts += attempts;
                    break;
                case 2:
                    displayTotalAttempts(totalAttempts);
                    break;
                case 3:
                    exitGame();
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }
    }

    public static void displayMenu() {
        System.out.println("******************** Welcome to the Number Guessing Game! ********************");
        System.out.println("1. Play a game");
        System.out.println("2. View total attempts");
        System.out.println("3. Exit");
    }

    public static void displayTotalAttempts(int totalAttempts) {
        System.out.println("Total number of attempts made: " + totalAttempts);
    }

    public static void exitGame() {
        System.out.println("Exiting the game. Goodbye!");
    }

    public static int playGame(Random random, int minRange, int maxRange, int attemptsLimit, Scanner scanner) {
        int score = 0;
        int attempts = 0;

        while (true) {
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            boolean guessedCorrectly = false;

            System.out.println("I've picked a number between " + minRange + " and " + maxRange + ". Guess what it is!");

            while (attempts < attemptsLimit) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed it right in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score++;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
            }

            System.out.println("Your score for this round: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        return attempts;
    }
}
