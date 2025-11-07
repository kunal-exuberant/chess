// Player.java
public class Player {
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(int points) {
        if (points > 0) {
            score += points;
            System.out.println(name + " scored " + points + " points. Total score: " + score);
        } else {
            System.out.println("Points must be positive.");
        }
    }

    public void displayInfo() {
        System.out.println("Player: " + name + ", Score: " + score);
    }
}

// AugmentedPlayer.java
public class AugmentedPlayer extends Player {
    private String specialAbility;

    public AugmentedPlayer(String name, String specialAbility) {
        super(name);
        this.specialAbility = specialAbility;
    }

    public String getSpecialAbility() {
        return specialAbility;
    }

    public void useSpecialAbility() {
        System.out.println(getName() + " uses special ability: " + specialAbility);
    }
}

// Main.java
public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Alice");
        player1.increaseScore(10);
        player1.displayInfo();

        AugmentedPlayer player2 = new AugmentedPlayer("Bob", "Double Jump");
        player2.increaseScore(20);
        player2.useSpecialAbility();
        player2.displayInfo();
    }
}