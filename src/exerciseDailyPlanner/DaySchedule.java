package exerciseDailyPlanner;

import java.util.ArrayList;
import java.util.List;

public class DaySchedule {
    private final Day day;
    private List<String> activities = new ArrayList<>();

    public DaySchedule(Day day, List<String> activities) {
        this.day = day;
        this.activities.addAll(activities);
    }

    public Day getDay() {
        return day;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "DaySchedule{" +
                "day=" + day +
                ", activities=" + activities +
                '}';
    }
}
