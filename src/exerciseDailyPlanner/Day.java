package exerciseDailyPlanner;

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

}


