package exerciseA3;

public class IntTools {
    private int number;

    public IntTools(int number) {
        this.number = number;
    }

    public int digitSum() {
        int digitSum = 0;
        String numberString = String.valueOf(number);
        for (int index = 0; index < numberString.length(); index++) {
            int digit = Character.getNumericValue(numberString.charAt(index));
            digitSum += digit;
        }
        return digitSum;
    }

    public int lastDigit() {
        return number % 10;
    }

    public int digitAt(int index) throws InvalidIndexException {
        String numberString = String.valueOf(number);
        if (index < 0 || index > numberString.length()) {
            throw new InvalidIndexException("Index is not valid!");
        } else {
            return Character.getNumericValue(numberString.charAt(index));
        }
    }
}