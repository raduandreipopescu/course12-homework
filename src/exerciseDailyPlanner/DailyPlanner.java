package exerciseDailyPlanner;

import java.util.*;

public class DailyPlanner {
    private List<DaySchedule> planner;

    public DailyPlanner(List<DaySchedule> planner) {
        this.planner = planner;
    }

    public void addActivity(Day day, String activity) throws NoActivityException {
        if (activity == null) {
            throw new NoActivityException("No sent activity");
        }
        if (planner == null) {
            planner = new ArrayList<>();
        }
        boolean dayFound = false;
        for (DaySchedule daySchedule : planner) {
            if (day.equals(daySchedule.getDay())) {
                dayFound = true;
                try {
                    daySchedule.getActivities().add(activity);
                } catch (NullPointerException exception) {
                    daySchedule.setActivities(new ArrayList<>());
                    daySchedule.getActivities().add(activity);
                }
            }
        }
        if (!dayFound) {
            List<String> activities = new ArrayList<>();
            activities.add(activity);
            planner.add(new DaySchedule(day, activities));
        }
    }

    public void removeActivity(Day day, String activity) throws NoActivityException {
        for (DaySchedule daySchedule : planner) {
            if (day.equals(daySchedule.getDay()) && daySchedule.getActivities().contains(activity)) {
                List<String> activities = daySchedule.getActivities();
                activities.remove(activity);
                daySchedule.setActivities(activities);
            } else {
                throw new NoActivityException("Activity not found!");
            }
        }
    }

    public List<String> getActivities(Day day) {
        for (DaySchedule daySchedule : planner) {
            if (day.equals(daySchedule.getDay())) {
                return daySchedule.getActivities();
            }
        }
        return new ArrayList<>();
    }

    public Map<Day, List<String>> endPlanning() throws NoActivitiesForDayException {
        Map<Day, List<String>> dayToActivities = new HashMap<>();
        dayToActivities.put(Day.MONDAY, null);
        dayToActivities.put(Day.TUESDAY, null);
        dayToActivities.put(Day.WEDNESDAY, null);
        dayToActivities.put(Day.THURSDAY, null);
        dayToActivities.put(Day.FRIDAY, null);
        dayToActivities.put(Day.SATURDAY, null);
        dayToActivities.put(Day.SUNDAY, null);
        for (DaySchedule daySchedule : planner) {
            dayToActivities.put(daySchedule.getDay(), daySchedule.getActivities());
        }

        for (Map.Entry<Day, List<String>> entry : dayToActivities.entrySet()) {
            if (entry.getValue() == null) {
                throw new NoActivitiesForDayException(entry.getKey() + " -> Enjoy a day off!");
            }
        }
        return dayToActivities;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (DaySchedule daySchedule : planner) {
            stringBuilder.append("Day: ").append(daySchedule.getDay()).append(" Activities: ").append(daySchedule.getActivities().toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
