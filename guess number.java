import java.util.Scanner;
import java.util.Random;

class Game {
    private int number;
    private int userInput;
    private int noOfGuesses;
    private int maxRange;

    Scanner sc = new Scanner(System.in);
    Random rand = new Random();

    // Start the game
    public void startGame() {
        setDifficulty();
        generateNumber();
        playGame();
        showResult();
        askReplay();
    }

    // Set difficulty level
    private void setDifficulty() {
        System.out.println("Choose Difficulty:");
        System.out.println("1. Easy (1-50)");
        System.out.println("2. Medium (1-100)");
        System.out.println("3. Hard (1-200)");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                maxRange = 50;
                break;
            case 2:
                maxRange = 100;
                break;
            case 3:
                maxRange = 200;
                break;
            default:
                System.out.println("Invalid choice. Default set to Medium.");
                maxRange = 100;
        }
    }

    // Generate random number
    private void generateNumber() {
        number = rand.nextInt(maxRange) + 1;
        noOfGuesses = 0;
    }

    // Main game loop
    private void playGame() {
        boolean guessed = false;

        while (!guessed) {
            takeUserInput();
            guessed = checkGuess();
        }
    }

    // Take input with validation
    private void takeUserInput() {
        System.out.print("Enter your guess (1 to " + maxRange + "): ");

        while (!sc.hasNextInt()) {
            System.out.println("Invalid input! Please enter a number.");
            sc.next(); // clear invalid input
        }

        userInput = sc.nextInt();
    }

    // Check guess
    private boolean checkGuess() {
        noOfGuesses++;

        if (userInput == number) {
            return true;
        } else if (userInput < number) {
            System.out.println("Too low!");
        } else {
            System.out.println("Too high!");
        }
        return false;
    }

    // Show result
    private void showResult() {
        System.out.println("\n🎉 Correct! The number was: " + number);
        System.out.println("Total attempts: " + noOfGuesses);
    }

    // Replay option
    private void askReplay() {
        System.out.print("\nDo you want to play again? (yes/no): ");
        String choice = sc.next();

        if (choice.equalsIgnoreCase("yes")) {
            startGame();
        } else {
            System.out.println("Thanks for playing! 👋");
        }
    }
}

public class GuessGame {
    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
