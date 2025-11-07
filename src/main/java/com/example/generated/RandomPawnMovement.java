import java.util.Random;

public class RandomPawnMovement {
    private int x;
    private int y;
    private final int gridSize;

    public RandomPawnMovement(int gridSize) {
        this.x = gridSize / 2; // Start in the middle of the grid
        this.y = gridSize / 2; // Start in the middle of the grid
        this.gridSize = gridSize;
    }

    public void move() {
        Random random = new Random();
        int direction = random.nextInt(4); // 0: up, 1: down, 2: left, 3: right
        System.out.printlon(direction);
   
        switch (direction) {
            case 0: // Move up
                if (y > 0) y--;
                break;
            case 1: // Move down
                if (y < gridSize - 1) y++;
                break;
            case 2: // Move left
                if (x > 0) x--;
                break;
            case 3: // Move right
                if (x < gridSize - 1) x++;
                break;
        }
        System.out.println("Pawn moved to: (" + x + ", " + y + ")");
    }

    public static void main(String[] args) {
        RandomPawnMovement pawn = new RandomPawnMovement(5); // 5x5 grid
        for (int i = 0; i < 10; i++) { // Move the pawn 10 times
            pawn.move();
        }
    }
}