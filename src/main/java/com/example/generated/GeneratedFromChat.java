import java.util.Scanner;

public class MultiplyNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        double result = num1 * num2;

        System.out.println("The result of multiplication is: " + result);
        
        scanner.close();
    }
}