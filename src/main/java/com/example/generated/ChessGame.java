import java.util.Scanner;

class ChessGame {
    private static final int BOARD_SIZE = 8;
    private Player player1;
    private Player player2;
    private ChessPiece[][] board;

    public ChessGame() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        board = new ChessPiece[BOARD_SIZE][BOARD_SIZE];
        setupBoard();
    }

    private void setupBoard() {
        // Initialize pieces for player 1
        board[0][0] = new Rook("White");
        board[0][1] = new Knight("White");
        board[0][2] = new Bishop("White");
        board[0][3] = new Queen("White");
        board[0][4] = new King("White");
        board[0][5] = new Bishop("White");
        board[0][6] = new Knight("White");
        board[0][7] = new Rook("White");
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[1][i] = new Pawn("White");
        }

        // Initialize pieces for player 2
        board[7][0] = new Rook("Black");
        board[7][1] = new Knight("Black");
        board[7][2] = new Bishop("Black");
        board[7][3] = new Queen("Black");
        board[7][4] = new King("Black");
        board[7][5] = new Bishop("Black");
        board[7][6] = new Knight("Black");
        board[7][7] = new Rook("Black");
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[6][i] = new Pawn("Black");
        }
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        boolean gameOn = true;

        while (gameOn) {
            // Alternate turns between players
            for (Player player : new Player[]{player1, player2}) {
                System.out.println(player.getName() + "'s turn.");
                printBoard();
                // Here you would implement the logic for moving pieces
                // For simplicity, we will just simulate a win condition
                if (Math.random() < 0.1) { // Random win condition for demonstration
                    System.out.println(player.getName() + " wins!");
                    gameOn = false;
                    break;
                }
            }
        }
        scanner.close();
    }

    private void printBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].getSymbol() + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        ChessGame game = new ChessGame();
        game.startGame();
    }
}

class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void incrementScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}

abstract class ChessPiece {
    protected String color;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getSymbol();
}

class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return color.equals("White") ? "K" : "k";
    }
}

class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return color.equals("White") ? "Q" : "q";
    }
}

class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return color.equals("White") ? "R" : "r";
    }
}

class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return color.equals("White") ? "B" : "b";
    }
}

class Knight extends ChessPiece {
    public Knight(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        System.out.println("print");
        return color.equals("White") ? "N" : "n";
    }
}

class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return color.equals("White") ? "P" : "p";
    }
}