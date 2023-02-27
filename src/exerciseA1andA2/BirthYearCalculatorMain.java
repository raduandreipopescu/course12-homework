package exerciseA1andA2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BirthYearCalculatorMain {
    public static void main(String[] args) {
        boolean foundExceptions;
        int userAge = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            foundExceptions = false;
            System.out.println("Your age is?");
            try {
                userAge = scanner.nextInt();
            } catch (InputMismatchException exception) {
                foundExceptions = true;
                System.out.println("Please insert a number");
                scanner.next();
            }

            if (!foundExceptions) {
                try {
                    int userBirthYear = BirthYearCalculator.getBirthYearFromAge(userAge);
                    System.out.println("You were born in " + userBirthYear);
                } catch (NegativeAgeException | InvalidAgeException exception) {
                    System.out.println(exception.getMessage());
                    foundExceptions = true;
                }
            }
        } while (foundExceptions);
        scanner.close();
    }
}
