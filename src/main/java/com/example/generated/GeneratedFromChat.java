import java.util.Scanner;

public class GKQuiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;

        System.out.println("Welcome to the GK Quiz!");
        
        // Question 1
        System.out.println("1. What is the capital of France?");
        System.out.println("a) Berlin");
        System.out.println("b) Madrid");
        System.out.println("c) Paris");
        System.out.println("d) Rome");
        System.out.print("Your answer: ");
        String answer1 = scanner.nextLine();
        if (answer1.equalsIgnoreCase("c")) {
            score++;
        }

        // Question 2
        System.out.println("2. Who wrote 'Hamlet'?");
        System.out.println("a) Charles Dickens");
        System.out.println("b) Mark Twain");
        System.out.println("c) William Shakespeare");
        System.out.println("d) Leo Tolstoy");
        System.out.print("Your answer: ");
        String answer2 = scanner.nextLine();
        if (answer2.equalsIgnoreCase("c")) {
            score++;
        }

        // Question 3
        System.out.println("3. What is the largest planet in our solar system?");
        System.out.println("a) Earth");
        System.out.println("b) Jupiter");
        System.out.println("c) Saturn");
        System.out.println("d) Mars");
        System.out.print("Your answer: ");
        String answer3 = scanner.nextLine();
        if (answer3.equalsIgnoreCase("b")) {
            score++;
            System.out.println(score);
        }

        // Final score
        System.out.println("You scored " + score + " out of 3.");
        scanner.close();
    }
}