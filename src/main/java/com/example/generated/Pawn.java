public class Pawn {
    private int position; // Position on the board (0-7 for a single row)

    public Pawn(int startingPosition) {
        if (startingPosition < 0 || startingPosition > 7) {
            throw new IllegalArgumentException("Starting position must be between 0 and 7.");
        }
        this.position = startingPosition;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        if (position < 7) {
            position++;
        } else {
            throw new IllegalStateException("Pawn cannot move forward, it is at the end of the board.");
        }
    }

    public void moveTwoSquaresForward() {
        if (position == 1) {
            position += 2;
        } else {
            throw new IllegalStateException("Pawn can only move two squares forward from the starting position.");
        }
    }
}