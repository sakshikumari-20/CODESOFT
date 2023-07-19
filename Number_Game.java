import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {
    private int numberToGuess;
    private int attempts;
    private int maxAttempts;

    public NumberGuessingGame(int maxAttempts) {
        Random random = new Random();
        numberToGuess = random.nextInt(100) + 1;
        attempts = 0;
        this.maxAttempts = maxAttempts;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and 100.");

        while (attempts < maxAttempts) {
            System.out.print("Take a guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < numberToGuess) {
                System.out.println("Too low!");
            } else if (guess > numberToGuess) {
                System.out.println("Too high!");
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                scanner.close();
                return;
            }
        }

        System.out.println("Sorry, you've reached the maximum number of attempts.");
        System.out.println("The number I was thinking of was: " + numberToGuess);
        scanner.close();
    }
}

public class Number_Game {
    public static void main(String[] args) {
        int maxAttempts = 10;
        NumberGuessingGame game = new NumberGuessingGame(maxAttempts);
        game.play();
    }
}
