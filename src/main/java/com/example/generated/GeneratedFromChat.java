import java.util.Scanner;

public class Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number (dividend): ");
        double dividend = scanner.nextDouble();

        System.out.print("Enter the second number (divisor): ");
        double divisor = scanner.nextDouble();

        if (divisor != 0) {
            double result = dividend / divisor;
            System.out.println("Result: " + result);
        } else {
            System.out.println("Error: Division by zero is not allowed.");
        }

        scanner.close();
    }
}