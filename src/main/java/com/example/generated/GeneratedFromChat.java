import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomChessMove {

    public static void main(String[] args) {
        // Example usage
        String piece = "Knight"; // Example piece
        String position = "e4"; // Example starting position
        String newPosition = getRandomMove(piece, position);
        System.out.println("Random move for " + piece + " from " + position + " to " + newPosition);
    }

    public static String getRandomMove(String piece, String position) {
        List<String> validMoves = getValidMoves(piece, position);
        if (validMoves.isEmpty()) {
            return position; // No valid moves, return the same position
        }
        Random random = new Random();
        return validMoves.get(random.nextInt(validMoves.size()));
    }

    public static List<String> getValidMoves(String piece, String position) {
        List<String> moves = new ArrayList<>();
        int x = position.charAt(0) - 'a'; // Convert column 'a'-'h' to 0-7
        int y = position.charAt(1) - '1'; // Convert row '1'-'8' to 0-7

        switch (piece) {
            case "Knight":
                // Knight moves in an "L" shape
                int[][] knightMoves = {
                    {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
                    {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
                };
                for (int[] move : knightMoves) {
                    int newX = x + move[0];
                    int newY = y + move[1];
                    if (isValidPosition(newX, newY)) {
                        moves.add("" + (char) (newX + 'a') + (newY + '1'));
                    }
                }
                break;
            // Additional pieces can be added here with their respective move logic
        }
        return moves;
    }

    public static boolean isValidPosition(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8; // Validating the chessboard boundaries
    }
}