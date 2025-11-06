import java.util.Random;
import java.util.Scanner;

public class MultiplayerGame {
    private static final int MAX_NUMBER = 10;
    private static final int MAX_PLAYERS = 2;
    private static int[] scores;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scores = new int[MAX_PLAYERS];
        Random random = new Random();

        for (int round = 1; round <= 5; round++) { // 5 rounds of guessing
            System.out.println("Round " + round);
            int numberToGuess = random.nextInt(MAX_NUMBER) + 1;

            for (int player = 0; player < MAX_PLAYERS; player++) {
                System.out.println("Player " + (player + 1) + ", it's your turn to guess:");
                int guess = scanner.nextInt();

                if (guess == numberToGuess) {
                    System.out.println("Correct! Player " + (player + 1) + " scores a point.");
                    scores[player]++;
                } else {
                    System.out.println("Wrong guess! The correct number was " + numberToGuess);
                }
            }
        }

        // Display final scores
        System.out.println("Final Scores:");
        for (int player = 0; player < MAX_PLAYERS; player++) {
            System.out.println("Player " + (player + 1) + ": " + scores[player] + " points");
        }

        scanner.close();
    }
}