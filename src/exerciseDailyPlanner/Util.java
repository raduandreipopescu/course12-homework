package exerciseDailyPlanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {

    public static int checkAnswer(StringBuilder stringBuilder, int lowerLimit, int upperLimit, Scanner scanner) {

        int selectedOption = 0;
        boolean wrongSelection;
        do {
            wrongSelection = false;
            System.out.println(stringBuilder);

            try {
                selectedOption = scanner.nextInt();
            } catch (InputMismatchException exception) {
                wrongSelection = true;
                System.out.println("Wrong selection!");
                scanner.next();
            }

            if (!wrongSelection && (selectedOption < lowerLimit || selectedOption > upperLimit)) {
                wrongSelection = true;
                System.out.println("Wrong selection!");
            }
        } while (wrongSelection);
        return selectedOption;
    }
}
