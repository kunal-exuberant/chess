package com.chess;

public class Pawn {
    private int position; // Position on the board (0-63 for an 8x8 board)
    private boolean isWhite; // True if the pawn is white, false if black

    public Pawn(int position, boolean isWhite) {
        this.position = position;
        this.isWhite = isWhite;
    }

    public boolean canMove(int newPosition) {
        int direction = isWhite ? 8 : -8; // White moves up, black moves down
        int startRow = isWhite ? 1 : 6; // Starting row for white and black pawns

        // Move forward one square
        if (newPosition == position + direction) {
            return true;
        }

        // Move forward two squares from starting position
        if (position / 8 == startRow && newPosition == position + 2 * direction) {
            return true;
        }

        // Capture diagonally
        if (newPosition == position + direction - 1 || newPosition == position + direction + 1) {
            return true;
        }

        return false;
    }

    public int getPosition() {
        return position;
    }

    public boolean isWhite() {
        return isWhite;
    }
}