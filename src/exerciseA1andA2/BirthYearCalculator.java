package exerciseA1andA2;

import java.time.Year;

public class BirthYearCalculator {
    protected static int getBirthYearFromAge(int age) throws NegativeAgeException, InvalidAgeException {
        if (age < 0) {
            throw new NegativeAgeException("Age can not be negative");
        }
        if (age > 150) {
            throw new InvalidAgeException("Not a valid age (>150 years)");
        }
        int currentYear = Year.now().getValue();
        return (currentYear - age);
    }
}
