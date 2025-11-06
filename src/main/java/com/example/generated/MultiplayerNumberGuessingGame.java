import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MultiplayerNumberGuessingGame {
    private final List<Player> players;
    private final int targetNumber;
    private int currentPlayerIndex;

    public MultiplayerNumberGuessingGame(int numberOfPlayers) {
        players = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player("Player " + i));
        }
        targetNumber = new Random().nextInt(100) + 1; // Target number between 1 and 100
        currentPlayerIndex = 0;
    }

    public void startGame() {
        boolean hasWinner = false;
        while (!hasWinner) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println(currentPlayer.getName() + ", it's your turn. Guess the number:");
            Scanner scanner = new Scanner(System.in);
            int guess = scanner.nextInt();

            if (guess == targetNumber) {
                System.out.println(currentPlayer.getName() + " wins!");
                hasWinner = true;
            } else {
                System.out.println("Wrong guess! Try again.");
                currentPlayerIndex = (currentPlayerIndex + 1) % players.size(); // Move to the next player
            }
        }
    }

    public static void main(String[] args) {
        MultiplayerNumberGuessingGame game = new MultiplayerNumberGuessingGame(3); // 3 players
        game.startGame();
    }
}

class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}