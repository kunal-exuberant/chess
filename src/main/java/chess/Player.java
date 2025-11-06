// src/main/java/chess/Player.java
package chess;

public class Player {
    private final String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// src/main/java/chess/Game.java
package chess;

public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1; // Player 1 starts
    }

    public String playTurn() {
        // Simulate a turn and randomly decide a winner for simplicity
        if (Math.random() > 0.5) {
            return currentPlayer.getName() + " wins!";
        } else {
            currentPlayer = (currentPlayer == player1) ? player2 : player1; // Switch player
            return "Next turn for " + currentPlayer.getName();
        }
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}