import java.util.Scanner;

class ChessGame {
    private static final int BOARD_SIZE = 8;
    private Player player1;
    private Player player2;
    private Piece[][] board;

    public ChessGame() {
        player1 = new Player("Player 1");
        player2 = new Player("Player 2");
        board = new Piece[BOARD_SIZE][BOARD_SIZE];
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
        boolean isPlayer1Turn = true;

        while (true) {
            displayBoard();
            Player currentPlayer = isPlayer1Turn ? player1 : player2;
            System.out.println(currentPlayer.getName() + "'s turn. Enter move (e.g., e2 e4): ");
            String move = scanner.nextLine();
            // Here you would implement move validation and execution
            // For simplicity, we will just toggle turns
            isPlayer1Turn = !isPlayer1Turn;
        }
    }

    private void displayBoard() {
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

    public void incrementScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }
}

abstract class Piece {
    protected String color;

    public Piece(String color) {
        this.color = color;
    }

    public abstract String getSymbol();
}

class King extends Piece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return color.equals("White") ? "K" : "k";
    }
}

class Queen extends Piece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return color.equals("White") ? "Q" : "q";
    }
}

class Rook extends Piece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return color.equals("White") ? "R" : "r";
    }
}

class Bishop extends Piece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return color.equals("White") ? "B" : "b";
    }
}

class Knight extends Piece {
    public Knight(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return color.equals("White") ? "N" : "n";
    }
}

class Pawn extends Piece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return color.equals("White") ? "P" : "p";
    }
}