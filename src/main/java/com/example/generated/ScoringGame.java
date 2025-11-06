import java.util.Scanner;

public class ScoringGame {
    private int score;

    public ScoringGame() {
        this.score = 0;
    }

    public void performAction(String action) {
        switch (action.toLowerCase()) {
            case "score":
                addScore(10); // Example: add 10 points for scoring action
                System.out.println("You scored! Current score: " + score);
                break;
            case "miss":
                subtractScore(5); // Example: subtract 5 points for a miss
                System.out.println("You missed! Current score: " + score);
                break;
            default:
                System.out.println("Invalid action. No score change.");
        }
    }

    private void addScore(int points) {
        score += points;
    }

    private void subtractScore(int points) {
        score -= points;
        if (score < 0) {
            score = 0; // Prevent negative score
        }
    }

    public int getScore() {
        return score;
    }

    public static void main(String[] args) {
        ScoringGame game = new ScoringGame();
        Scanner scanner = new Scanner(System.in);
        String action;

        System.out.println("Welcome to the Scoring Game!");
        System.out.println("Type 'score' to score points, 'miss' to miss points, or 'exit' to quit.");

        while (true) {
            System.out.print("Enter action: ");
            action = scanner.nextLine();

            if (action.equalsIgnoreCase("exit")) {
                System.out.println("Final score: " + game.getScore());
                break;
            }

            game.performAction(action);
        }

        scanner.close();
    }
}