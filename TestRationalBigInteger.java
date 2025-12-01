import java.math.BigInteger;
import java.util.Scanner;

/*
    This program tests the RationalBigInteger class by allowing the user
    to enter two rational numbers in the form numerator/denominator.

    1. Reads two rational numbers as strings
    2. Parses each into a RationalBigInteger object
    3. Performs addition, subtraction, multiplication, and division
        using BigInteger arithmetic
    4. Displays the results in a readable format
    5. Outputs the decimal equivalent of the second rational number
*/

public class TestRationalBigInteger {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Prompt user for two rational numbers in "a/b" format
        System.out.print("Enter the first rational number (numerator/denominator): ");
        String r1String = input.next();

        System.out.print("Enter the second rational number (numerator/denominator): ");
        String r2String = input.next();

        // Convert user input strings into RationalBigInteger objects
        RationalBigInteger r1 = parse(r1String);
        RationalBigInteger r2 = parse(r2String);

        // Display results of arithmetic operations
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));

        // Show the decimal approximation of the second rational number
        System.out.println(r2 + " is " + r2.doubleValue());
    }

    /**
     * Converts a string like "3/4" into a RationalBigInteger object.
     * Splits the string into numerator and denominator parts, converts
     * them to BigInteger, and constructs the rational number.
     */
    private static RationalBigInteger parse(String fraction) {
        fraction = fraction.trim();

        BigInteger num;
        BigInteger den;

        if (fraction.contains("/")) {
            String[] parts = fraction.split("/");
            num = new BigInteger(parts[0].trim());
            den = new BigInteger(parts[1].trim());
        } else {
            num = new BigInteger(fraction);
            den = BigInteger.ONE;
        }

        return new RationalBigInteger(num, den);
    }
}