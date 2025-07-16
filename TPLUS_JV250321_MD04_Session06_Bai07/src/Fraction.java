public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        checkDenominator(denominator);

        this.numerator = numerator;
        this.denominator = denominator;

        simplify();
    }

    private void checkDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Mẫu số không được bằng 0");
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        simplify();
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        checkDenominator(denominator);
        this.denominator = denominator;
        simplify();
    }

    public Fraction add(Fraction other) {
        int tuMoi = this.numerator * other.denominator + other.numerator * this.denominator;
        int mauMoi = this.denominator * other.denominator;
        return new Fraction(tuMoi, mauMoi);
    }

    public Fraction subtract(Fraction other) {
        int tuMoi = this.numerator * other.denominator - other.numerator * this.denominator;
        int mauMoi = this.denominator * other.denominator;
        return new Fraction(tuMoi, mauMoi);
    }

    public Fraction multiply(Fraction other) {
        int tuMoi = this.numerator * other.numerator;
        int mauMoi = this.denominator * other.denominator;
        return new Fraction(tuMoi, mauMoi);
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Không thể chia cho phân số có tử số bằng 0");
        }
        int tuMoi = this.numerator * other.denominator;
        int mauMoi = this.denominator * other.numerator;
        return new Fraction(tuMoi, mauMoi);
    }

    private void simplify() {
        int ucln = findGCD(Math.abs(numerator), Math.abs(denominator));
        numerator = numerator / ucln;
        denominator = denominator / ucln;

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    private int findGCD(int a, int b) {
        while (b != 0) {
            int tam = b;
            b = a % b;
            a = tam;
        }
        return a;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}
