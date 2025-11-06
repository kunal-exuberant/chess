import java.util.Scanner;

public class GKQuiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String[] questions = {
            "1. What is the capital of France?",
            "2. Who wrote 'Hamlet'?",
            "3. What is the largest planet in our solar system?",
            "4. What is the chemical symbol for water?",
            "5. Who painted the Mona Lisa?"
        };
        
        String[] answers = {
            "Paris",
            "Shakespeare",
            "Jupiter",
            "H2O",
            "Leonardo da Vinci"
        };
        
        int score = 0;
        
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            String userAnswer = scanner.nextLine();
            
            if (userAnswer.equalsIgnoreCase(answers[i])) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is: " + answers[i]);
            }
        }
        
        System.out.println("Your total score: " + score + "/" + questions.length);
        scanner.close();
    }
}