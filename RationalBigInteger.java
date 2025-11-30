import java.math.BigInteger;

/**
    RationalBigInteger represents a rational number using BigInteger
    instead of int. This allows the program to support extremely large
    numbers without overflow.
 */
public class RationalBigInteger extends Number implements Comparable<RationalBigInteger> {

    // The numerator of the rational number
    private BigInteger numerator = BigInteger.ZERO;

    // The denominator of the rational number (always positive)
    private BigInteger denominator = BigInteger.ONE;

    /** Default constructor ( creates 0/1 ) */
    public RationalBigInteger() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    /** Construct a rational number with numerator and denominator.

        Normalizes numeric value by:
            - preventing (0) in the denominator
            - reducing numerator/denominator using GCD (greatest common devisor)
            - always keeping a positive denominator
    */
    public RationalBigInteger(BigInteger numerator, BigInteger denominator) {

        // Handle zero denominator / enforces rule: denominator cannot be zero
        if (denominator.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }

        // Find GCD and normalize the fraction
        BigInteger gcd = numerator.gcd(denominator);

        // If denominator is negative, pull sign to numerator.
        BigInteger sign = (denominator.compareTo(BigInteger.ZERO) > 0)
                ? BigInteger.ONE : BigInteger.valueOf(-1);

        // Normalize numerator (Divide by GCD and apply sign)

        this.numerator = numerator.divide(gcd).multiply(sign);

        // Normalize denominator (Always positive, divide by GCD)
        this.denominator = denominator.abs().divide(gcd);
    }

    /** Return numerator */
    public BigInteger getNumerator() {
        return numerator;
    }

    /** Return denominator */
    public BigInteger getDenominator() {
        return denominator;
    }

    /** Add a rational number: (a/b) + (c/d) = (ad + bc) / bd */
    public RationalBigInteger add(RationalBigInteger r) {
        BigInteger n = numerator.multiply(r.getDenominator())
                        .add(denominator.multiply(r.getNumerator()));
        BigInteger d = denominator.multiply(r.getDenominator());
        return new RationalBigInteger(n, d);
    }

    /** Subtract a rational number: (a/b) - (c/d) = (ad - bc) / bd */
    public RationalBigInteger subtract(RationalBigInteger r) {
        BigInteger n = numerator.multiply(r.getDenominator())
                        .subtract(denominator.multiply(r.getNumerator()));
        BigInteger d = denominator.multiply(r.getDenominator());
        return new RationalBigInteger(n, d);
    }

    /** Multiply a rational number: (a/b) * (c/d) = (a*c) / (b*d) */
    public RationalBigInteger multiply(RationalBigInteger r) {
        BigInteger n = numerator.multiply(r.getNumerator());
        BigInteger d = denominator.multiply(r.getDenominator());
        return new RationalBigInteger(n, d);
    }

    /** Divide a rational number: (a/b) ÷ (c/d) = (a*d) / (b*c) */
    public RationalBigInteger divide(RationalBigInteger r) {
        BigInteger n = numerator.multiply(r.getDenominator());
        BigInteger d = denominator.multiply(r.getNumerator());
        return new RationalBigInteger(n, d);
    }

    /**
    Converts the rational number to a string.
        - If denominator is 1, show only the numerator (ex: "5" not "5/1")
    */
    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE)) {
            return numerator + "";
        }
        return numerator + "/" + denominator;
    }

    /**
    Two rational numbers are considered equal if their difference
        - has a numerator of zero (they cancel out).
    */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RationalBigInteger)) return false;
        RationalBigInteger r = (RationalBigInteger) o;
        return this.subtract(r).getNumerator().equals(BigInteger.ZERO);
    }

    // Compares two rational numbers using subtraction.
    @Override
    public int compareTo(RationalBigInteger r) {
        BigInteger diff = this.subtract(r).getNumerator();
        return diff.compareTo(BigInteger.ZERO);
    }

    /** Implement Number abstract methods */
    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    // Converts numerator/denominator to a double.
    @Override
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }
}
