import java.util.Random;

class Player {
    private String name;
    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 0; // Starting position
    }

    public void move() {
        Random random = new Random();
        int steps = random.nextInt(10) + 1; // Random steps between 1 and 10
        position += steps;
        System.out.println(name + " moved " + steps + " steps to position " + position);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}

public class Game {
    public static void main(String[] args) {
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        player1.move();
        player2.move();
    }
}