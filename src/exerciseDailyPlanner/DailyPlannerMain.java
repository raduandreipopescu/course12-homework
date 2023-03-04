package exerciseDailyPlanner;

import java.util.Scanner;

public class DailyPlannerMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        int selectedOption;

        do {
            selectedOption = menu.functionalitySwitch(menu.mainMenu());
        } while (selectedOption != 4);
        scanner.close();
    }
}
