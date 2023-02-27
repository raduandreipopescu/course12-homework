package exerciseA3;

public class IntToolsMain {
    public static void main(String[] args) {
        IntTools myInt = new IntTools(5463);

        System.out.println("The digits sum is: " + myInt.digitSum());

        System.out.println("Last digit is: " + myInt.lastDigit());

        try {
            System.out.println("Digit at position 1 is: " + myInt.digitAt(1));
            System.out.println("Digit at position 20 is: " + myInt.digitAt(20));
        } catch (InvalidIndexException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
