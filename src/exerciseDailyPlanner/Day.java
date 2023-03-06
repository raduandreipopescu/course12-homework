package exerciseDailyPlanner;

import java.time.DayOfWeek;

public enum Day {
    MONDAY("monday"),
    TUESDAY("tuesday"),
    WEDNESDAY("wednesday"),
    THURSDAY("thursday"),
    FRIDAY("friday"),
    SATURDAY("saturday"),
    SUNDAY("sunday");

    private final String day;

    public String getDay() {
        return this.day;
    }

    Day(String day) {
        this.day = day;
    }

//    DayOfWeek
//    Asta este un enum similar celui facut de noi (din java.time.*)
}


