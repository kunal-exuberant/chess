package likedriving.design.Chess.Pieces;

import likedriving.design.Chess.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static likedriving.design.Chess.Utils.logPieceStatus;

@Data
public abstract class Piece {

    private static byte pieceId = 0;
    private byte id;
    private PieceType pieceType;
    private Color color;
    private DirectionOfAttack directionOfAttack;
    private Position currentPosition;
    private boolean isCaptured = false;

    public Piece(PieceType pieceType, Color color) {
        this.id = pieceId++;
        this.pieceType = pieceType;
        this.color = color;
        this.directionOfAttack = DirectionOfAttack.INCREASING;
        if (color == Color.BLACK) this.directionOfAttack = DirectionOfAttack.DECREASING;
    }

    protected abstract Direction[] myMoveOrder();

    public abstract boolean canAttack();

    protected boolean isMyPiecePresent(Cell nextCell) {
        if (!nextCell.isAvailable() && nextCell.getPiecePlaced().getColor() == this.getColor()) {
            return false;
        }
        return true;
    }

    public boolean canMoveTo(Position position) {
        return false;
    }

    protected boolean isOpponent(Piece piece) {
        if (piece == null) return false;
        return this.getColor() != piece.getColor();
    }

    protected boolean canAttackHere(Cell cell) {
        return cell != null && (cell.isAvailable() || isOpponent(cell.getPiecePlaced()));
    }

    protected boolean canCapture(Cell cell) {
        return isOpponent(cell.getPiecePlaced());
    }

    protected Cell navigateOneStepInMyDirection(Direction direction, Position position) {
        switch (direction) {
            case NEXT:
                return Navigation.next(position, getDirectionOfAttack());
            case LEFT:
                return Navigation.left(position, getDirectionOfAttack());
            case RIGHT:
                return Navigation.right(position, getDirectionOfAttack());
            case PREVIOUS:
                return Navigation.previous(position, getDirectionOfAttack());
            case DIAGONAL_LEFT:
                return Navigation.diagonalLeft(position, getDirectionOfAttack());
            case DIAGONAL_RIGHT:
                return Navigation.diagonalRight(position, getDirectionOfAttack());
            case DIAGONAL_LEFT_BACK:
                return Navigation.diagonalLeftBack(position, getDirectionOfAttack());
            case DIAGONAL_RIGHT_BACK:
                return Navigation.diagonalRightBack(position, getDirectionOfAttack());
            case JUMP_UP_LEFT:
                return Navigation.jumpUpLeftPosition(position, getDirectionOfAttack());
            case JUMP_UP_RIGHT:
                return Navigation.jumpUpRightPosition(position, getDirectionOfAttack());
            case JUMP_LEFT_UP:
                return Navigation.jumpLeftUpPosition(position, getDirectionOfAttack());
            case JUMP_RIGHT_UP:
                return Navigation.jumpRightUpPosition(position, getDirectionOfAttack());
            case JUMP_LEFT_DOWN:
                return Navigation.jumpLeftDownPosition(position, getDirectionOfAttack());
            case JUMP_RIGHT_DOWN:
                return Navigation.jumpRightDownPosition(position, getDirectionOfAttack());
            case JUMP_DOWN_LEFT:
                return Navigation.jumpDownLeftPosition(position, getDirectionOfAttack());
            case JUMP_DOWN_RIGHT:
                return Navigation.jumpDownRightPosition(position, getDirectionOfAttack());
            default:
                System.out.println("Unknown navigation direction: " + direction);
                return null;
        }
    }

    public void logUpdatedPosition(Cell updatedCell) {
        Board.getCell(getCurrentPosition()).setAvailable(true);
        updatedCell.setAvailable(false);
        updatedCell.setPiecePlaced(this);
        setCurrentPosition(updatedCell.getPosition());
        System.out.print("to " + updatedCell.getPosition());
    }

    public void move() {
        Cell tempCell = null;
        boolean ownPiece = false;

        Cell updatedCell = null;


        for (int i = 0; i < myMoveOrder().length; i++) {
            tempCell = navigateOneStepInMyDirection(myMoveOrder()[i], getCurrentPosition());
            if (tempCell != null) {
                while (tempCell != null && !canCapture(tempCell)) {
                    if (tempCell.isAvailable()) {
                        updatedCell = tempCell;
                        tempCell = navigateOneStepInMyDirection(myMoveOrder()[i], tempCell.getPosition());
                    } else {
                        ownPiece = true;
                        break;
                    }
                }
                if (!ownPiece && tempCell != null) {
                    Piece capturedPiece = tempCell.getPiecePlaced();
                    logUpdatedPosition(tempCell);
                    logPieceStatus(capturedPiece);
                    break;
                } else {
                    if (i == myMoveOrder().length - 1 && updatedCell != null) {
                        logUpdatedPosition(updatedCell);
                    } else {
                        System.out.println("Should capture last known position which was different from my current position");
                    }
                }
            } else {
                if (i == myMoveOrder().length - 1 && updatedCell != null) {
                    logUpdatedPosition(updatedCell);
                } else {
                    System.out.println("Location not found on board");
                }
            }
        }
    }

    @Override
    public boolean equals(Object piece) {
        if (this.id == ((Piece) piece).getId()) {
            return true;
        }
        return false;
    }


    public List<Cell> getPossibleMoves() {

        List<Cell> possibleMoves = new ArrayList<>();
        Cell tempCell = null;

        for (int i = 0; i < myMoveOrder().length; i++) {
            tempCell = navigateOneStepInMyDirection(myMoveOrder()[i], getCurrentPosition());
            while (tempCell != null && (canCapture(tempCell) || tempCell.isAvailable())) {
                possibleMoves.add(tempCell);
                if(!tempCell.isAvailable()) {
                    break;
                }
                tempCell = navigateOneStepInMyDirection(myMoveOrder()[i], tempCell.getPosition());
            }
        }
        return possibleMoves;
    }
}
