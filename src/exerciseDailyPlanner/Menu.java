package exerciseDailyPlanner;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    DailyPlanner dailyPlanner;
    Scanner scanner;

    public Menu(Scanner scanner) {
        this.dailyPlanner = new DailyPlanner(new ArrayList<>());
        this.scanner = scanner;
    }

    public int mainMenu() {
        StringBuilder stringBuilder = new StringBuilder("""
                Please choose an option:
                1) add an activity
                2) remove an activity
                3) list all activities
                4) end planning
                """);
        return Util.checkAnswer(stringBuilder, 1, 4, scanner);
    }

    public int functionalitySwitch(int selectedOption) {
        switch (selectedOption) {
            case 1 -> {
                addActivity();
                return selectedOption;
            }
            case 2 -> {
                removeActivity();
                return selectedOption;
            }
            case 3 -> {
                getActivitiesForDay();
                return selectedOption;
            }
            case 4 -> {
                endPlanning();
                return selectedOption;
            }
        }
        return -1;
    }

    public void addActivity() {
        Day selectedDay = selectDay();
        System.out.println("Write activity to add: ");
        String activity = scanner.next();
        try {
            dailyPlanner.addActivity(selectedDay, activity);
        } catch (NoActivityException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeActivity() {
        Day selectedDay = selectDay();
        System.out.println("Write activity to remove: ");
        String activity = scanner.next();
        try {
            dailyPlanner.removeActivity(selectedDay, activity);
        } catch (NoActivityException e) {
            System.out.println(e.getMessage());
        }
    }

    public void getActivitiesForDay() {
        Day selectedDay = selectDay();
        System.out.println("Activities for " + selectedDay.getDay() + " are: " + dailyPlanner.getActivities(selectedDay));
    }

    public void endPlanning() {
        try {
            dailyPlanner.endPlanning();
        } catch (NoActivitiesForDayException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Final planner : \n" + dailyPlanner);
        }
    }

    public Day selectDay() {
        StringBuilder stringBuilder = new StringBuilder("""
                Please select a day:
                1) monday
                2) tuesday
                3) wednesday
                4) thursday
                5) friday
                6) saturday
                7) sunday
                """);
        int selectedDay = Util.checkAnswer(stringBuilder, 1, 7, scanner);
        switch (selectedDay) {
            case 1 -> {
                return Day.MONDAY;
            }
            case 2 -> {
                return Day.TUESDAY;
            }
            case 3 -> {
                return Day.WEDNESDAY;
            }
            case 4 -> {
                return Day.THURSDAY;
            }
            case 5 -> {
                return Day.FRIDAY;
            }
            case 6 -> {
                return Day.SATURDAY;
            }
            case 7 -> {
                return Day.SUNDAY;
            }
        }
        return null;
    }
}
