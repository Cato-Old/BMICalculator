import Calculator.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int weight = 0;
        int height = 0;

        Scanner scanner = new Scanner(System.in);
        while (weight == 0){
            System.out.println("Input your weight in kg: ");
            try {
                weight = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Inappropriate weight");
            }
        }

        while (height == 0){
            System.out.println("Input your height in cm: ");
            try {
                height = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Inappropriate weight");
            }
        }

        try {
            Calculator calc = new BMICalculator(weight,height);
            System.out.println("You are: " + calc.interpret());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }
    }
}